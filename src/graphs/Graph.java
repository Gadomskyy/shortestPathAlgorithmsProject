package graphs;

import java.util.*;

public class Graph {
    private final List<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode(Node n) {
        nodes.add(n);
    }

    public void addEdgeToGraph(Edge e) {
        if (!nodes.contains(e.getFrom()) || !nodes.contains(e.getTo())) {
            throw new IllegalArgumentException("Both nodes must be in the graph: " + e.getFrom() + ", " + e.getTo());
        }
        e.getFrom().addEdge(e);
    }

    public void addUndirectedEdge(Node a, Node b, double weight) {
        addEdgeToGraph(new Edge(a, b, weight));
        addEdgeToGraph(new Edge(b, a, weight));
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void printGraph(boolean weighted) {
        System.out.println("Graph structure:");
        for (Node node : nodes) {
            System.out.print(node + " -> ");
            for (Edge edge : node.getEdges()) {
                if (weighted) {
                    System.out.print(edge.getTo() + "(" + edge.getWeight() + ") ");
                } else {
                    System.out.print(edge.getTo() + " ");
                }
            }
            System.out.println();
        }
    }

    public List<Node> buildPath(Map<Node, Node> previous, Node start, Node goal) {
        List<Node> path = new ArrayList<>();
        for (Node n = goal; n != null; n = previous.get(n)) {
            path.add(n);
        }
        Collections.reverse(path);
        if (path.size() == 1 && !path.get(0).equals(start)) return null; // brak ścieżki
        return path;
    }

    public void printPath(List<Node> path, String algoName, Map<Node, Double> distances) {
        if (path == null || path.isEmpty()) {
            System.out.println("No path found using " + algoName);
            return;
        }

        System.out.print(algoName + " path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) System.out.print(" -> ");
        }

        if (distances != null && distances.containsKey(path.get(path.size() - 1))) {
            System.out.println(" | Total cost: " + distances.get(path.get(path.size() - 1)));
        } else {
            System.out.println();
        }
    }


    public List<Node> BFSShortestPath(Node start, Node goal) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> previous = new HashMap<>();

        queue.add(start);
        visited.add(start);
        previous.put(start, null);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.equals(goal)) break;

            for (Edge edge : current.getEdges()) {
                Node neighbor = edge.getTo();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        List<Node> path = buildPath(previous, start, goal);
        printPath(path, "BFS", null);
        return path;
    }

    public List<Node> dijkstraShortestPath(Node start, Node goal) {
        Map<Node, Double> distances = new HashMap<>();
        Map<Node, Node> previous = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        for (Node node : nodes) {
            distances.put(node, Double.POSITIVE_INFINITY);
            previous.put(node, null);
        }

        distances.put(start, 0.0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited.contains(current)) continue;
            visited.add(current);
            if (current.equals(goal)) break;

            for (Edge edge : current.getEdges()) {
                Node neighbor = edge.getTo();
                double newDist = distances.get(current) + edge.getWeight();
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }

        List<Node> path = buildPath(previous, start, goal);
        printPath(path, "Dijkstra", distances);
        return path;
    }
}
