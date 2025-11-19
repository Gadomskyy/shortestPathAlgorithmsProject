public class Main {
    public static void main(String[] args) {

        Node a = new Node("A");
        Node b = new Node("B");

        Edge e1 = new Edge(a, b, 5.0);

        a.addEdge(e1);

        System.out.println("Created nodes:");
        System.out.println("Node A id: " + a.getId());
        System.out.println("Node B id: " + b.getId());

        System.out.println("\nEdges from A:");
        for (Edge e : a.getEdges()) {
            System.out.println(e);
        }

        System.out.println("\nEdge info:");
        System.out.println("From: " + e1.getFrom());
        System.out.println("To: " + e1.getTo());
        System.out.println("Weight: " + e1.getWeight());
    }
}