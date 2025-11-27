package graphs;

public class Main {
    public static void main(String[] args) {

        //this code just showcase the usage of Graph, Node, Edges classes
        //can be modified or deleted
        Graph graph = new Graph();

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);

        graph.addEdgeToGraph(new Edge(a, b));
        graph.addEdgeToGraph(new Edge(a, c));
        graph.addEdgeToGraph(new Edge(b, d));
        graph.addEdgeToGraph(new Edge(c, d));
        graph.addEdgeToGraph(new Edge(d, a));

        System.out.println("Graph structure:");
        for (Node node : graph.getNodes()) {
            System.out.print(node + " -> ");
            for (Edge e : node.getEdges()) {
                System.out.print(e.getTo() + " ");
            }
            System.out.println();
        }
    }
}
