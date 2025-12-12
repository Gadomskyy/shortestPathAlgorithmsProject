package graphs;

import java.util.*;


//TODO: is the class name correct or should it be changed?
public class Functions {

    // Creates a random unweighted, undirected graph with number of nodes as requested in parameter
    // Each pair of nodes has a 50% chance to be connected
    // Node can't have an edge with itself

    public static Graph createUnweightedGraph(int number) {
        Graph g = new Graph();


        for (int i = 0; i < number; i++) {
            g.addNode(new Node("N" + i));
        }

        Random r = new Random();

        List<Node> nodes = g.getNodes();
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (r.nextBoolean()) {
                    Node a = nodes.get(i);
                    Node b = nodes.get(j);

                    // add both directions (undirected graph) - to be modified if we ever need directed
                    g.addEdgeToGraph(new Edge(a, b));
                    g.addEdgeToGraph(new Edge(b, a));
                }
            }
        }

        return g;
    }
    public static Graph createWeightedGraph(int number, int maxWeight) {
        Graph g = new Graph();

        for (int i = 0; i < number; i++) {
            g.addNode(new Node("N" + i));
        }

        Random r = new Random();
        List<Node> nodes = g.getNodes();

        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (r.nextBoolean()) {
                    Node a = nodes.get(i);
                    Node b = nodes.get(j);

                    // Losowa waga od 1 do maxWeight
                    int weight = 1 + r.nextInt(maxWeight);

                    g.addEdgeToGraph(new Edge(a, b, weight));
                    g.addEdgeToGraph(new Edge(b, a, weight));
                }
            }
        }

        return g;
    }
}



