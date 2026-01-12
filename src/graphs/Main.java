package graphs;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        int WIDTH  = 1920;
        int HEIGHT = 1080;

        Graph graph = Functions.createUnweightedGraph(12, WIDTH, HEIGHT);

        System.out.println("\n=== BFS ===");
        graph.printGraph(false);

        Node start = graph.getNodes().get(0);
        Node goal = graph.getNodes().get(5);

        BFSResult bfsResult = graph.BFSShortestPathWithTrace(start, goal);

        //generowanie svg
        GraphVisualizer visualizer = new GraphVisualizer();
        String svg = visualizer.BFStoSVG(graph, bfsResult, WIDTH, HEIGHT);

        //zapis do pliku
        try (FileWriter writer = new FileWriter("bfs_graph.svg")) {
            writer.write(svg);
            System.out.println("SVG saved as bfs_graph.svg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Graph graph2 = Functions.createWeightedGraph(6, 5, 800, 600);
        graph2.printGraph(true);

        Node start2 = graph2.getNodes().get(0);
        Node goal2 = graph2.getNodes().get(5);

        System.out.println("\n=== DIJKSTRA ===");
        graph2.dijkstraShortestPath(start2, goal2);

        List<Node> dijkstraPath = graph2.dijkstraShortestPath(start2, goal2);

        String dijkstraSvg = visualizer.dijkstraToSVG(
                graph2,
                dijkstraPath,
                WIDTH,
                HEIGHT
        );

        // zapis do pliku
        try (FileWriter writer = new FileWriter("dijkstra_graph.svg")) {
            writer.write(dijkstraSvg);
            System.out.println("SVG saved as dijkstra_graph.svg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== A* GRID ===");

        GridGraph grid = new GridGraph(10, 10);
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
