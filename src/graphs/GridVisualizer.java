package graphs;

import java.util.HashSet;
import java.util.Set;

public class GridVisualizer {

    // rozmiar jednego pola w px
    private static final int CELL_SIZE = 30;

    /**
     * Generates SVG visualization of A* search on a grid.
     *
     * Colors:
     * - black  : obstacles
     * - green  : final path
     * - blue   : visited nodes
     * - white  : normal cells
     */
    public String AStarToSVG(
            GridGraph grid,
            AStarResult result,
            int width,   // zachowane dla spójności API (jak BFS)
            int height
    ) {

        int svgWidth = grid.getWidth() * CELL_SIZE;
        int svgHeight = grid.getHeight() * CELL_SIZE;

        StringBuilder svg = new StringBuilder();

        svg.append("<svg xmlns=\"http://www.w3.org/2000/svg\" ")
                .append("width=\"").append(svgWidth).append("\" ")
                .append("height=\"").append(svgHeight).append("\" ")
                .append("viewBox=\"0 0 ").append(svgWidth).append(" ")
                .append(svgHeight).append("\">");

        // szybkie wyszukiwanie
        Set<GridNode> path = new HashSet<>(result.getPath());
        Set<GridNode> visited = new HashSet<>(result.getVisitOrder());

        // rysowanie siatki
        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {

                String fillColor = "#ffffff"; // domyślny kolor

                GridNode node = new GridNode(x, y);

                if (grid.isBlocked(x, y)) {
                    fillColor = "#000000"; // przeszkoda
                } else if (path.contains(node)) {
                    fillColor = "#90db8b"; // ścieżka
                } else if (visited.contains(node)) {
                    fillColor = "#8ecae6"; // odwiedzone
                }

                // pole
                svg.append("<rect ")
                        .append("x=\"").append(x * CELL_SIZE).append("\" ")
                        .append("y=\"").append(y * CELL_SIZE).append("\" ")
                        .append("width=\"").append(CELL_SIZE).append("\" ")
                        .append("height=\"").append(CELL_SIZE).append("\" ")
                        .append("fill=\"").append(fillColor).append("\" ")
                        .append("stroke=\"gray\" stroke-width=\"1\" />");

                // waga (jeśli nie przeszkoda)
                if (!grid.isBlocked(x, y)) {
                    svg.append("<text ")
                            .append("x=\"").append(x * CELL_SIZE + CELL_SIZE / 2).append("\" ")
                            .append("y=\"").append(y * CELL_SIZE + CELL_SIZE / 2).append("\" ")
                            .append("text-anchor=\"middle\" ")
                            .append("dominant-baseline=\"middle\" ")
                            .append("font-size=\"12\">")
                            .append(grid.getWeight(x, y))
                            .append("</text>");
                }
            }
        }

        svg.append("</svg>");
        return svg.toString();
    }
}

