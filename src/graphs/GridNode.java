package graphs;

import java.util.Objects;

public class GridNode {
    private final int x;
    private final int y;

    public GridNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GridNode)) return false;
        GridNode gridNode = (GridNode) o;
        return x == gridNode.x && y == gridNode.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
