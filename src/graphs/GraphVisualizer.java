package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphVisualizer {

    public String BFStoSVG(Graph graph, BFSResult bfsResult,
                        int width, int height) {

        StringBuilder svg = new StringBuilder();


        svg.append("<svg xmlns=\"http://www.w3.org/2000/svg\" ")
                .append("width=\"").append(width).append("\" ")
                .append("height=\"").append(height).append("\" ")
                .append("viewBox=\"0 0 ").append(width).append(" ")
                .append(height).append("\">");

        //dane BFS
        Set<Node> visitedNodes = new HashSet<>(bfsResult.getVisitOrder());
        Set<String> pathEdges = new HashSet<>();

        List<Node> path = bfsResult.getPath();
        if (path != null) {
            for (int i = 0; i < path.size() - 1; i++) {
                pathEdges.add(path.get(i) + "->" + path.get(i + 1));
            }
        }

        //krawedzie
        for (Node from : graph.getNodes()) {
            for (Edge edge : from.getEdges()) {

                Node to = edge.getTo();
                boolean onPath = pathEdges.contains(from + "->" + to);

                svg.append("<line ")
                        .append("x1=\"").append(from.getX()).append("\" ")
                        .append("y1=\"").append(from.getY()).append("\" ")
                        .append("x2=\"").append(to.getX()).append("\" ")
                        .append("y2=\"").append(to.getY()).append("\" ")
                        .append("stroke=\"").append(onPath ? "red" : "#999").append("\" ")
                        .append("stroke-width=\"").append(onPath ? 3 : 1).append("\" />");
            }
        }

        //wezly
        for (Node node : graph.getNodes()) {

            String fillColor = visitedNodes.contains(node)
                    ? "#8ecae6"
                    : "#eeeeee";

            svg.append("<circle ")
                    .append("cx=\"").append(node.getX()).append("\" ")
                    .append("cy=\"").append(node.getY()).append("\" ")
                    .append("r=\"20\" ")
                    .append("fill=\"").append(fillColor).append("\" ")
                    .append("stroke=\"black\" stroke-width=\"2\" />");

            svg.append("<text ")
                    .append("x=\"").append(node.getX()).append("\" ")
                    .append("y=\"").append(node.getY()).append("\" ")
                    .append("text-anchor=\"middle\" ")
                    .append("dominant-baseline=\"middle\" ")
                    .append("font-size=\"14\">")
                    .append(node.getId())
                    .append("</text>");
        }

        svg.append("</svg>");
        return svg.toString();
    }
}
