package graphs;

import java.util.*;

public class GridGraph {

    private final int width;
    private final int height;

    // przeszkody
    private final boolean[][] blocked;

    // wagi pól (koszt wejścia na pole)
    private final int[][] weights;

    private final Random random = new Random();

    public GridGraph(int width, int height) {
        this.width = width;
        this.height = height;
        this.blocked = new boolean[height][width];
        this.weights = new int[height][width];

        generateRandomWeights(1, 5);
    }

    /* =======================
       GENERATORY
       ======================= */

    // losowe wagi pól
    private void generateRandomWeights(int min, int max) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                weights[y][x] = min + random.nextInt(max - min + 1);
            }
        }
    }

    // losowe przeszkody (np. 20% pól)
    public void generateRandomObstacles(double probability) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                blocked[y][x] = random.nextDouble() < probability;
            }
        }
    }

    // ręczne ustawienie przeszkody
    public void setBlocked(int x, int y, boolean value) {
        if (inBounds(x, y)) {
            blocked[y][x] = value;
        }
    }

    /* =======================
       POMOCNICZE
       ======================= */

    private boolean inBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    /* =======================
       SĄSIEDZI
       ======================= */

    public List<GridNode> getNeighbors(GridNode node) {
        List<GridNode> neighbors = new ArrayList<>();

        int x = node.getX();
        int y = node.getY();

        int[][] directions = {
                { 1, 0 },   // prawo
                { -1, 0 },  // lewo
                { 0, 1 },   // dół
                { 0, -1 }   // góra
        };

        for (int[] d : directions) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (inBounds(nx, ny) && !blocked[ny][nx]) {
                neighbors.add(new GridNode(nx, ny));
            }
        }

        return neighbors;
    }

    /* =======================
       HEURYSTYKA (Manhattan)
       ======================= */

    private double heuristic(GridNode a, GridNode b) {
        return Math.abs(a.getX() - b.getX())
                + Math.abs(a.getY() - b.getY());
    }

    /* =======================
       KOSZT RUCHU
       ======================= */

    private double cost(GridNode from, GridNode to) {
        // koszt wejścia na pole docelowe
        return weights[to.getY()][to.getX()];
    }

    /* =======================
       ODTWARZANIE ŚCIEŻKI
       ======================= */

    private List<GridNode> reconstructPath(
            Map<GridNode, GridNode> cameFrom,
            GridNode current
    ) {
        List<GridNode> path = new ArrayList<>();
        path.add(current);

        while (cameFrom.containsKey(current)) {
            current = cameFrom.get(current);
            path.add(current);
        }

        Collections.reverse(path);
        return path;
    }

    /* =======================
       A* SEARCH
       ======================= */

    public AStarResult aStar(GridNode start, GridNode goal) {

        List<GridNode> visitOrder = new ArrayList<>();

        Map<GridNode, Double> gScore = new HashMap<>();
        Map<GridNode, GridNode> cameFrom = new HashMap<>();

        PriorityQueue<GridNode> openSet = new PriorityQueue<>(
                Comparator.comparingDouble(n ->
                        gScore.getOrDefault(n, Double.POSITIVE_INFINITY)
                                + heuristic(n, goal))
        );

        gScore.put(start, 0.0);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            GridNode current = openSet.poll();
            visitOrder.add(current);

            if (current.equals(goal)) {
                return new AStarResult(
                        visitOrder,
                        reconstructPath(cameFrom, current)
                );

            }

            for (GridNode neighbor : getNeighbors(current)) {
                double tentativeG =
                        gScore.get(current) + cost(current, neighbor);

                if (tentativeG < gScore.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeG);

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }
        return new AStarResult(visitOrder, new ArrayList<>());
    }

    public AStarResult aStarWithTrace(GridNode start, GridNode goal) {

        Map<GridNode, Double> gScore = new HashMap<>();
        Map<GridNode, GridNode> cameFrom = new HashMap<>();

        // kolejność odwiedzania węzłów (do wizualizacji)
        List<GridNode> visitedOrder = new ArrayList<>();

        PriorityQueue<GridNode> openSet = new PriorityQueue<>(
                Comparator.comparingDouble(n ->
                        gScore.getOrDefault(n, Double.POSITIVE_INFINITY)
                                + heuristic(n, goal))
        );

        gScore.put(start, 0.0);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            GridNode current = openSet.poll();

            // zapamiętujemy kolejność odwiedzin
            visitedOrder.add(current);

            if (current.equals(goal)) {
                List<GridNode> path = reconstructPath(cameFrom, current);
                return new AStarResult(visitedOrder, path);
            }

            for (GridNode neighbor : getNeighbors(current)) {

                double tentativeG =
                        gScore.get(current) + cost(current, neighbor);

                if (tentativeG < gScore.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {

                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeG);

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        // brak ścieżki
        return new AStarResult(visitedOrder, null);
    }

        /* =======================
       GETTERY (DO WIZUALIZACJI)
       ======================= */

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isBlocked(int x, int y) {
        return blocked[y][x];
    }

    public int getWeight(int x, int y) {
        return weights[y][x];
    }

}

