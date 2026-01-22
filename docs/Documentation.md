# Documentation


## 1. Graph Class
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