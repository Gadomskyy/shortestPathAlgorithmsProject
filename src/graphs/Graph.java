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
}
