package graphs;

public class Main {
    public static void main(String[] args) {

        //this code just showcase the usage of implemented classes and methods
        //can be modified or deleted
        Graph graph = Functions.createUnweightedGraph(6);

        graph.printGraph(false);

        //Node start = graph.getNodes().getFirst();
        Node goal = graph.getNodes().get(5);

        //graph.BFSShortestPath(start, goal);

        Node start2 = graph.getNodes().get(0);
        Node goal2 = graph.getNodes().get(5);

        System.out.println("\n=== DIJKSTRA ===");
        graph.dijkstraShortestPath(start2,goal2);
    }
}
