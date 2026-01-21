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

        int GRID_WIDTH = 20;
        int GRID_HEIGHT = 15;

        GridGraph grid = new GridGraph(GRID_WIDTH, GRID_HEIGHT);
        grid.generateRandomObstacles(0.2); // 20% przeszkód

        GridNode start3 = new GridNode(0, 0);
        GridNode goal3 = new GridNode(GRID_WIDTH - 1, GRID_HEIGHT - 1);

        AStarResult aStarResult = grid.aStarWithTrace(start3, goal3);

        List<GridNode> path = aStarResult.getPath();

        if (!path.isEmpty()) {
            System.out.println("Path found:");
            for (GridNode n : path) {
                System.out.print(n + " ");
            }
        } else {
            System.out.println("No path found");
        }

        // generowanie SVG
        GridVisualizer visualizerAStar = new GridVisualizer();
        String svgAStar = visualizerAStar.AStarToSVG(
                grid,
                aStarResult,
                800,
                600
        );

        // zapis do pliku
        try (FileWriter writer = new FileWriter("astar_grid.svg")) {
            writer.write(svgAStar);
            System.out.println("SVG saved as astar_grid.svg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
