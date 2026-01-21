package graphs;

import java.util.List;

public class AStarResult {

    private final List<GridNode> visitOrder;
    private final List<GridNode> path;

    public AStarResult(List<GridNode> visitOrder, List<GridNode> path) {
        this.visitOrder = visitOrder;
        this.path = path;
    }

    public List<GridNode> getVisitOrder() {
        return visitOrder;
    }

    public List<GridNode> getPath() {
        return path;
    }
}
