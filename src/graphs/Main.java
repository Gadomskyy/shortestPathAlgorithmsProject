package graphs;

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
    }
}
