public class Edge {
    private final Node from;
    private final Node to;
    private final double weight;

    //constructor for unweighted graphs
    public Edge(Node from, Node to) {
        this(from, to, 1.0);
    }

    //constructor for weighted graphs
    public Edge(Node from, Node to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return from + " -> " + to + " (" + weight + ")";
    }
}