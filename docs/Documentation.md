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

