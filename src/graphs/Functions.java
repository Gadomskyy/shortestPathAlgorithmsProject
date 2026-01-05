package graphs;

import java.util.*;

public class Functions {

    public static Graph createGraph(int number, boolean weighted, int maxWeight, int width, int height) {

        Graph g = new Graph();

        Random random = new Random();

        int margin = 120; // margines zeby wezly nie byly za blisko siebie

        //tworzenie wezlow z losowymi wspolrzednymi
        for (int i = 0; i < number; i++) {
            double x = margin + random.nextDouble() * (width - 2 * margin);
            double y = margin + random.nextDouble() * (height - 2 * margin);

            g.addNode(new Node("N" + i, x, y));
        }

        List<Node> nodes = g.getNodes();

        //losowe krawedzie
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (random.nextBoolean()) {
                    Node a = nodes.get(i);
                    Node b = nodes.get(j);

                    if (weighted) {
                        int weight = 1 + random.nextInt(maxWeight);
                        g.addEdgeToGraph(new Edge(a, b, weight));
                        g.addEdgeToGraph(new Edge(b, a, weight));
                    } else {
                        g.addEdgeToGraph(new Edge(a, b));
                        g.addEdgeToGraph(new Edge(b, a));
                    }
                }
            }
        }

        return g;
    }


    public static Graph createUnweightedGraph(int number, int width, int height) {
        return createGraph(number, false, 0, width, height);
    }

    public static Graph createWeightedGraph(int number, int maxWeight, int width, int height) {
        return createGraph(number, true, maxWeight, width, height);
    }
}
