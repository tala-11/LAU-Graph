The LAU Campus Navigation System is a Java-based application that helps users find the shortest path between two locations on the Lebanese American University (LAU) 
campus. This system is built using graphs (vertices and edges) and Dijkstra’s algorithm to calculate the shortest route between points. Users input a starting point 
and a destination, and the program provides step-by-step directions such as "Go left to [Location]" or "Go right to [Location]". This project uses basic data structures
and algorithms to offer an efficient way to navigate the campus.

Core Components:
Vertex: Represents a location on the campus, such as Shannon Hall or the Library.

Edge: Defines the path between two vertices, including direction and distance (weight).

Graph: Stores vertices and edges and includes the logic for pathfinding.

How It Works:
Locations are added as vertices.

Paths between locations are established using edges, with direction and weight (distance) assigned.

Dijkstra’s algorithm is applied to compute the shortest path from a given starting point to a destination.

Once the shortest path is found, the program generates a list of directions, guiding the user step by step.
