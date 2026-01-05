package graphs;
import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String id;
    private final List<Edge> edges;

    //wspolrzednie do rysowania
    private double x;
    private double y;

    public Node(String id) {
        this.id = id;
        this.edges = new ArrayList<>();
    }

    //konstruktor z wspolrzednymi
    public Node(String id, double x, double y) {
        this(id);
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return id;
    }
}

