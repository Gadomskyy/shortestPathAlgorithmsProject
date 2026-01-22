# Shortest Path Algorithms Project

This repository contains a Java implementation of classical **graph pathfinding and shortest path algorithms** (BFS, Dijkstra, A*), developed as part of **Team Project**

The goal of this project is to design and implement an optimal pathfinding system for graph-based environments and to study the correctness, optimality, and complexity of different shortest path algorithms.

##  Project Topic
The project focuses on:

- Designing a suitable **graph representation**
- Implementing classical shortest path algorithms
- Visually representing the graphs and their solutions
- Comparing different approaches on weighted and unweighted graphs

The implemented algorithms guarantee optimal solutions under their respective assumptions (e.g., BFS for unweighted graphs, Dijkstra for weighted graphs, etc.).

##  Repository Structure

```text
ShortestPathAlgorithms
├── README.md
├── Results/
│   ├── astar_grid.svg
│   ├── bfs_graph.svg
│   └── dijkstra_graph.svg
├── docs/
│   ├── ProjectRequirements.pdf
│   ├── sciaga.md
│   └── Documentation.md
└── src/
   └── graphs/
       ├── AStarResult.java
       ├── BFSResult.java
       ├── Edge.java
       ├── Functions.java
       ├── Graph.java
       ├── GraphVisualizer.java
       ├── GridGraph.java
       ├── GridNode.java
       ├── GridVisualizer.java
       ├── Main.java
       └── Node.java
```

All source code is written in **Java**.

## Implemented Components

For a more detailed explanation of projects classes and methods, please refer to the documentation.
Below you will find a shortened overview on the contents of the project.

## 1. Graph Representation

- `Graph.java` and the supporting classes implement a graph structure.
- The graph supports:
    - Adding vertices and edges
    - Neighbor expansion
    - Edge weight lookup
    - Manual setting of Nodes positions and Edges weights
    - (For A* algorithm) Manual setting of obstacles

This representation is suitable for implementing classical shortest path algorithms efficiently, as required in the assignment.

## 2. Implemented Algorithms

The following shortest path algorithms are implemented:

####  Breadth-First Search (BFS)

- Solves the **single-source shortest path problem in unweighted graphs**.
- Explores the graph **level by level** starting from the source.
- Guarantees shortest paths in terms of **minimum number of edges**.

####  Dijkstra’s Algorithm

- Solves the **single-source shortest path problem**.
- Works for graphs with **non-negative edge weights**.
- Guarantees optimal shortest paths (in terms of weights).

####  A* Search Algorithm

- Solves the **single-source shortest path problem using heuristics**.
- Uses an **admissible heuristic** to guide the search toward the goal.
- Guarantees **optimal shortest paths** when the heuristic is admissible.
- Typically faster than Dijkstra on larger graphs due to informed search.

##  3. Algorithmic Goals

This project demonstrates and compares:

- Correctness of shortest path algorithms
- Optimality guarantees under different graph assumptions
- Scalability of the algorithms for different sizes of graphs
- Visualizes the concepts to ensure it's correctness
- Differences between:
    - Single-source vs. all-pairs algorithms
    - Weighted vs. unweighted graph handling

##  4. End Goal
The result of the project are the visual representation of all three types of pathfinding algorithms.
Created in .svg format, it allows for an easy access and lookup into the algorithms' final results.

##  5. Requirements

To compile and run the project:

- **Java Development Kit (JDK) 11 or later**
- Any Java IDE (IntelliJ IDEA, Eclipse) or command-line tools

##  6. Build and Run

Clone the repository:

```
git clone https://github.com/Gadomskyy/shortestPathAlgorithmsProject.git
cd shortestPathAlgorithmsProject
```
Run the Main.java file.

## 7. Algorithms' complexity

### Computational and Memory Complexity of BFS, Dijkstra, and A*

---

## BFS (Breadth-First Search)

### Usage in the project
- Class: `Graph`
- Method: `BFSShortestPathWithTrace`
- Graph representation: adjacency list
- Graph type: **unweighted**

### Time Complexity
**O(V + E)**

Where:
- `V` – number of vertices (nodes)
- `E` – number of edges

**Explanation:**
- Each node is visited at most once
- Each edge is examined at most once

### Space Complexity
**O(V)**

Includes:
- BFS queue
- visited set
- `previous` map
- `visitOrder` list
- reconstructed `path`

---

##  Dijkstra’s Algorithm

### Usage in the project
- Class: `Graph`
- Method: `dijkstraShortestPath`
- Edge weights: **non-negative**
- Data structure: `PriorityQueue`

### Time Complexity
**O((V + E) · log V)**


### Space Complexity
**O(V)**

Includes:
- distance map
- predecessor map
- priority queue
- reconstructed path

---

## A* (A-Star)

### Usage in the project
- Class: `GridGraph`
- Methods: `aStar`, `aStarWithTrace`
- Heuristic: **Manhattan distance**
- Movement: 4-directional
- Cost model: cost of entering a cell (`weights[y][x]`)

---

### Time Complexity (worst case)
**O((V + E) · log V)**  
→ equivalent to Dijkstra’s algorithm

### Time Complexity (practical – grid-based)
**O(V log V)**, but:
- typically **much faster than Dijkstra** due to heuristic-guided exploration

For a grid of size `W × H`:
- `V = W · H`
- `E ≤ 4V`

**Worst case:**  
When the heuristic provides no guidance (`h = 0`), A* behaves like Dijkstra.

**Typical case:**  
Only a subset of the grid (toward the goal) is explored.

---

### Space Complexity
**O(V)**

Includes:
- `openSet` (priority queue)
- `gScore` map
- `cameFrom` map
- `visitedOrder` list
- reconstructed `path`

---

## Algorithms' Comparison

| Algorithm    | Time Complexity | Space Complexity | Notes |
|--------------|----------------|------------------|------|
| **BFS**      | O(V + E) | O(V) | Fastest, unweighted graphs only |
| **Dijkstra** | O(E log V) | O(V) | Supports weighted graphs |
| **A-Star**   | O(E log V)\* | O(V) | Fastest in practice with a good heuristic |

\* Often significantly faster in real scenarios.

---



