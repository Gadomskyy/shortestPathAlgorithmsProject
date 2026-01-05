package graphs;

import java.util.List;

public class BFSResult {
    private final List<Node> visitOrder;
    private final List<Node> path;

    public BFSResult(List<Node> visitOrder, List<Node> path) {
        this.visitOrder = visitOrder;
        this.path = path;
    }

    public List<Node> getVisitOrder() {
        return visitOrder;
    }

    public List<Node> getPath() {
        return path;
    }
}

