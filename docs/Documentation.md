# Documentation


# 1. Graph Class
The `Graph` class provides an object-oriented implementation of a directed and undirected graph with weighted edges.  
It supports:

- Construction and management of nodes and edges
- Visualization of graph structure
- Shortest path computation using:
    - Breadth-First Search (BFS) for unweighted graphs
    - Dijkstra’s algorithm for weighted graphs
- Path reconstruction and formatted output

The graph is internally represented as an adjacency list, where each `Node` maintains a list of outgoing `Edge` objects.

This class is intended for educational and algorithmic purposes and can be extended with additional graph algorithms.

---

### Class Signature

```
public class Graph
```

### Fields
private final List<Node> nodes;
```
private final List<Node> nodes;
```
- Stores all nodes currently in the graph.
- Only nodes in this list may be connected by edges.

### Constructors
```
Graph()
```

Creates an empty graph with no nodes.

### Node Management
```
public void addNode(Node n)
```
Adds a node to the graph.

- n – node to be added

### Edge Management
#### addEdgeToGraph
```
public void addEdgeToGraph(Edge e)
```

Adds a directed edge to the graph.

- e – edge containing from, to, and weight

#### addUndirectedEdge
```
public void addUndirectedEdge(Node a, Node b, double weight)
```
Adds an undirected edge by creating two directed edges:

- a → b

- b → a

Parameters:

a, b – endpoints

weight – edge weight

### Acessing Graph information

#### getNodes
```
public List<Node> getNodes()
```
Returns the list of all nodes in the graph.

#### printGraph
```
public void printGraph(boolean weighted)
```
Prints the adjacency list of the graph.

- weighted == true → prints neighbors with weights
- weighted == false → prints only neighbors

### Path utilities

#### buildPath
```
public List<Node> buildPath(Map<Node, Node> previous, Node start, Node goal)
```
- Reconstructs a path from start to goal using a predecessor map.

- Returns a list of nodes forming the path

- Returns null if no path exists

#### printPath
```
public void printPath(List<Node> path, String algoName, Map<Node, Double> distances)
```

Prints a formatted path and optional total cost.

### Shortest Path Algorithms

#### BFS (Unweighted)
```
public BFSResult BFSShortestPathWithTrace(Node start, Node goal)
```

Computes the shortest path using Breadth-First Search.

Suitable for **unweighted graphs only**.

Returns:

- visit order

- reconstructed shortest path

- Guarantees minimal number of edges.

#### Dijkstra (Weighted)
```
public List<Node> dijkstraShortestPath(Node start, Node goal)
```
Computes the shortest path using Dijkstra’s algorithm.

Uses a priority queue ordered by current distance.

Prints the path and total cost.

Constraints:

- All edge weights must be non-negative.

# 2. Edge Class

Represents a directed edge between two nodes, optionally with a weight.  
An edge connects a source node (`from`) to a target node (`to`).

---

### Constructors

#### Unweighted constructor
```
public Edge(Node from, Node to)
```

Creates an edge with a default weight of `1.0`.

- `from` – source node
- `to` – target node

Use this constructor for unweighted graphs.

---

#### Weighted constructor
```
public Edge(Node from, Node to, double weight)
```

Creates an edge with an explicit weight.

- `from` – source node
- `to` – target node
- `weight` – edge weight

Use this constructor for weighted graphs.

---

### Getters

#### getFrom
```
public Node getFrom()
```

Returns the source node of the edge.

---

#### getTo
```
public Node getTo()
```

Returns the target node of the edge.

---

#### getWeight
```
public double getWeight()
```

Returns the weight of the edge.

---

### String Representation

#### toString
```
public String toString()
```

Returns a string representation of the edge in the format:

```
from -> to (weight)
```

Example:

```
A -> B (2.5)
```

---

### Notes

- Edge direction is from `from` to `to`.
- Weight is always defined (default is `1.0` for unweighted graphs).


# 3. Node class

Represents a vertex in a graph.  
A node is identified by a unique string `id` and maintains a list of outgoing edges.  
Optionally, a node can store 2D coordinates for visualization purposes.

---

### Constructors

#### Basic constructor
```
public Node(String id)
```

Creates a node with the given identifier and no initial edges.

- `id` – unique identifier of the node

Initial state:
- `edges` is an empty list
- position is `(0.0, 0.0)` by default

---

#### Constructor with position
```
public Node(String id, double x, double y)
```

Creates a node with an identifier and initial coordinates.

- `id` – unique identifier of the node
- `x` – x-coordinate
- `y` – y-coordinate

Use this constructor when node layout or visualization is required.

---

### Getters

#### getId
```
public String getId()
```

Returns the identifier of the node.

---

#### getEdges
```
public List<Edge> getEdges()
```

Returns the list of outgoing edges from this node.

- The returned list is mutable.
- Modifying it directly affects the node’s adjacency list.

---

#### getX
```
public double getX()
```

Returns the x-coordinate of the node.

---

#### getY
```
public double getY()
```

Returns the y-coordinate of the node.

---

### Setters

#### addEdge
```
public void addEdge(Edge edge)
```

Adds an outgoing edge to this node.

- `edge` – edge to be added

This method is typically called by `Graph` when building the adjacency list.

---

#### setPosition
```
public void setPosition(double x, double y)
```

Sets the position of the node.

- `x` – new x-coordinate
- `y` – new y-coordinate


---

### String Representation

#### toString
```
public String toString()
```

Returns the string representation of the node.

- By default, returns the node `id`.


# 4. Functions class

Utility class providing methods for generating random graphs.  
Supports creation of weighted and unweighted graphs with randomly positioned nodes and randomly generated edges.

---

### Methods

#### createGraph
```
public static Graph createGraph(int number, boolean weighted, int maxWeight, int width, int height)
```

Creates a random graph with the specified parameters.

Parameters:

- `number` (`int`)  
  Number of nodes to generate.

- `weighted` (`boolean`)  
  Determines whether the graph is weighted:
  - `true`  – create weighted edges
  - `false` – create unweighted edges

- `maxWeight` (`int`)  
  Maximum possible edge weight (used only if `weighted == true`).  
  Actual weights are generated in the range `[1, maxWeight]`.

- `width` (`int`)  
  Width of the drawing area.

- `height` (`int`)  
  Height of the drawing area.

Behavior:

- Creates specified number of nodes with random 2D coordinates.
- Ensures nodes are placed inside the area with a fixed margin.
- For each pair of nodes `(i, j)`:
  - With 50% probability, creates an edge between them.
  - If `weighted == true`, assigns a random weight.
  - Adds edges in both directions, creating an undirected graph.

Returns:

- `Graph` – the generated random graph.

---

#### createUnweightedGraph
```
public static Graph createUnweightedGraph(int number, int width, int height)
```

Creates a random **unweighted** graph.

Parameters:

- `number` (`int`) – number of nodes
- `width` (`int`)  – drawing area width
- `height` (`int`) – drawing area height

Behavior:

- Calls `createGraph` with `weighted = false`.
- All edges have the default weight `1.0`.

Returns:

- `Graph` – the generated unweighted graph.

---

#### createWeightedGraph
```
public static Graph createWeightedGraph(int number, int maxWeight, int width, int height)
```

Creates a random **weighted** graph.

Parameters:

- `number` (`int`) – number of nodes
- `maxWeight` (`int`) – maximum edge weight
- `width` (`int`) – drawing area width
- `height` (`int`) – drawing area height

Behavior:

- Calls `createGraph` with `weighted = true`.
- Edge weights are generated in the range `[1, maxWeight]`.

Returns:

- `Graph` – the generated weighted graph.

---

### Notes

- Generated graphs are undirected (edges are added in both directions).
- Node positions are generated with a fixed margin to avoid clustering near borders.
- Edge existence is randomized using a 50% probability for each node pair.

# 5. GridNode Class

The `GridNode` class represents a node in a 2D grid using integer Cartesian coordinates.  
It is designed to be lightweight, immutable, and suitable for use in graph-based algorithms such as grid traversal, pathfinding, and spatial searches.

It supports:

- Immutable storage of `(x, y)` coordinates
- Coordinate accessors
- Proper equality comparison for use in collections
- Safe usage as keys in hash-based data structures
- Readable string representation

---

### Class Signature

```
public class GridNode
```

### Fields
```
private final int x;
private final int y;
```

- `x` – horizontal coordinate of the node
- `y` – vertical coordinate of the node

### Constructors
```
public GridNode(int x, int y)
```

Creates a grid node at the specified coordinates.

Parameters:

- `x` – x-coordinate
- `y` – y-coordinate

### Getters

#### getX
```
public int getX()
```
Returns the x-coordinate of the node.

#### getY
```
public int getY()
```
Returns the y-coordinate of the node.

### Equality and Hashing

#### equals
```
public boolean equals(Object o)
```

Determines equality based on coordinate values.

- Two `GridNode` objects are equal if they have the same `x` and `y` values.
- Enables correct comparison in collections and algorithms.

#### hashCode
```
public int hashCode()
```

Generates a hash code based on the node’s coordinates.

- Ensures consistency with `equals`
- Allows safe use as keys in `HashMap` and elements in `HashSet`

### String Representation

#### toString
```
public String toString()
```

Returns a readable string representation of the node in the format:

```
(x,y)
```

Useful for debugging, logging, and formatted output in pathfinding results.

---

# 6. GridGraph Class

The `GridGraph` class represents a 2D grid-based graph commonly used in pathfinding problems.  
Each cell in the grid corresponds to a `GridNode` and may have an associated movement cost or be blocked (an obstacle).

It provides a complete environment for grid-based pathfinding using the A* algorithm with Manhattan heuristic.

It supports:

- Grid initialization with configurable width and height
- Random generation of terrain weights
- Random and manual placement of obstacles
- Neighbor retrieval with 4-directional movement
- Cost-based movement between grid cells
- A* pathfinding with optional visit tracing
- Utilities for visualization and debugging

---

### Class Signature

```
public class GridGraph
```

### Fields
```
private final int width;
private final int height;
private final boolean[][] blocked;
private final int[][] weights;
private final Random random;
```

- `width`, `height` – grid dimensions
- `blocked` – marks cells that cannot be traversed
- `weights` – movement cost for entering each cell
- `random` – used for random generation of weights and obstacles

### Constructors
```
public GridGraph(int width, int height)
```

Creates a grid graph with the given dimensions.

- Initializes random weights in range `[1, 5]`
- No obstacles are set by default

Parameters:

- `width` – number of columns
- `height` – number of rows

---

## Grid Generation

### generateRandomObstacles
```
public void generateRandomObstacles(double probability)
```

Randomly marks grid cells as blocked.

- `probability` – chance (0.0–1.0) that a cell becomes an obstacle

### setBlocked
```
public void setBlocked(int x, int y, boolean value)
```

Manually sets or clears an obstacle at a given position.

- Safe bounds checking is applied

---

## Neighbor Access

### getNeighbors
```
public List<GridNode> getNeighbors(GridNode node)
```

Returns all valid neighboring nodes using **4-directional movement**:

- Right
- Left
- Down
- Up

Rules:

- Neighbor must be inside grid bounds
- Neighbor must not be blocked

---

## Heuristic Function

### heuristic (Manhattan Distance)
```
private double heuristic(GridNode a, GridNode b)
```

Computes Manhattan distance:

```
|x1 - x2| + |y1 - y2|
```

Used by the A* algorithm to guide search efficiently.

---

## Movement Cost

### cost
```
private double cost(GridNode from, GridNode to)
```

Returns the cost of entering the destination cell.

- Based on `weights[y][x]`
- Allows terrain-based pathfinding

---

## Path Utilities

### reconstructPath
```
private List<GridNode> reconstructPath(
    Map<GridNode, GridNode> cameFrom,
    GridNode current
)
```

Reconstructs the path from start to goal using a predecessor map.

- Returns ordered list of `GridNode`
- Used internally by A*

---

## A* Pathfinding

### aStar
```
public AStarResult aStar(GridNode start, GridNode goal)
```

Executes the A* search algorithm.

Returns:

- Order of visited nodes
- Shortest path from start to goal

If no path exists, returns an empty path.

### aStarWithTrace
```
public AStarResult aStarWithTrace(GridNode start, GridNode goal)
```

Extended version of A* that records full visitation order.

Returns:

- Visited node sequence (for visualization)
- Reconstructed shortest path
- Returns `null` path if no solution exists

---

## Visualization Utilities

### getWidth / getHeight
```
public int getWidth()
public int getHeight()
```

Return grid dimensions.

### isBlocked
```
public boolean isBlocked(int x, int y)
```

Checks whether a given cell is an obstacle.

### getWeight
```
public int getWeight(int x, int y)
```

Returns movement cost of a given cell.

---
# 7. BFSResult Class

The `BFSResult` class is a simple data container used to store the results of a **Breadth-First Search (BFS)** traversal or shortest-path computation.

It encapsulates both the order in which nodes were visited and the final reconstructed path (if one exists).

It supports:

- Storage of BFS visit order
- Storage of reconstructed shortest path
- Clean separation of algorithm logic and results
- Easy access for visualization or debugging

---

### Class Signature

```
public class BFSResult
```

### Fields
```
private final List<Node> visitOrder;
private final List<Node> path;
```

- `visitOrder` – nodes in the order they were visited during BFS
- `path` – reconstructed shortest path from start to goal
- Fields are immutable once the object is created

### Constructors
```
public BFSResult(List<Node> visitOrder, List<Node> path)
```

Creates a result object containing BFS traversal data.

Parameters:

- `visitOrder` – list of nodes in visitation order
- `path` – shortest path from start to goal (may be `null` or empty)

### Accessors

#### getVisitOrder
```
public List<Node> getVisitOrder()
```

Returns the list of nodes visited during BFS.

Useful for:

- Algorithm tracing
- Visualization
- Debugging traversal behavior

#### getPath
```
public List<Node> getPath()
```

Returns the reconstructed shortest path.

- If no path exists, this may be `null` or empty depending on usage context

---
# 8. AStarResult Class

The `AStarResult` class is a result container for the A* pathfinding algorithm executed on a grid-based graph.

It stores both the visitation order of nodes and the final path from start to goal, making it suitable for visualization and analysis of the algorithm’s behavior.

It supports:

- Storage of A* visit order
- Storage of reconstructed optimal path
- Clean result abstraction for pathfinding algorithms
- Easy integration with grid visualizers

---

### Class Signature

```
public class AStarResult
```

### Fields
```
private final List<GridNode> visitOrder;
private final List<GridNode> path;
```

- `visitOrder` – grid nodes visited during the A* search
- `path` – optimal path from start to goal
- Fields are immutable

### Constructors
```
public AStarResult(List<GridNode> visitOrder, List<GridNode> path)
```

Creates an object representing the outcome of an A* search.

Parameters:

- `visitOrder` – nodes visited in order of exploration
- `path` – reconstructed shortest path (may be `null` if no path exists)

### Accessors

#### getVisitOrder
```
public List<GridNode> getVisitOrder()
```

Returns the sequence of nodes explored by the algorithm.

Useful for:

- Step-by-step visualization
- Performance analysis
- Educational demonstrations

#### getPath
```
public List<GridNode> getPath()
```

Returns the reconstructed optimal path.

- Returns `null` if the goal was unreachable

---
