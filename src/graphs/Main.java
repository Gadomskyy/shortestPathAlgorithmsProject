package graphs;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //this code just showcase the usage of implemented classes and methods
        //can be modified or deleted
        Graph graph = Functions.createUnweightedGraph(6);

        graph.printGraph(false);

        Node start = graph.getNodes().get(0);
        Node goal = graph.getNodes().get(5);

        graph.BFSShortestPath(start, goal);
        Graph graph2 = Functions.createWeightedGraph(6,5);
        graph2.printGraph(true);
        Node start2 = graph2.getNodes().get(0);
        Node goal2 = graph2.getNodes().get(5);

        System.out.println("\n=== DIJKSTRA ===");
        graph2.dijkstraShortestPath(start2,goal2);

        System.out.println("\n=== A* GRID ===");

        GridGraph grid = new GridGraph(10, 10);

        // losowe przeszkody (np. 25%)
        grid.generateRandomObstacles(0.25);

        GridNode start3 = new GridNode(0, 0);
        GridNode goal3 = new GridNode(9, 9);

        List<GridNode> path = grid.aStar(start3, goal3);

        if (path != null) {
            System.out.println("Path found:");
            for (GridNode n : path) {
                System.out.print(n + " ");
            }
        } else {
            System.out.println("No path found");
        }

    }
}
