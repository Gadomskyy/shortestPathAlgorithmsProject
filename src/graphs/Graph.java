package graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final List<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode(Node n) {
        nodes.add(n);
    }

    public void addEdgeToGraph(Edge e) {
        e.getFrom().addEdge(e);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    //argument of the function lets us use it for both weighted and unweighted
    //true - weighted, false - unweighted
    public void printGraph(boolean weighted) {
        System.out.println("Graph structure:");
        for (Node node : getNodes()) {
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
}
