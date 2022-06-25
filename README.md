# DjikstraAlgorithm

Implementation of a weighted adjacency list repsentation of a weighted graph, and using this to apply Djikstra shortest path algorithm to a weighted graph

BinaryHeap is used here so that we can always have the shortest path from vertex -> vertex at the root of the heap, making it O(1) to find it

NodeDistance is used to contain the distance to a vertex and the path it took to get there

Vertex is an arraylist of integers that holds the distances to other vertexs

Graph is an arraylist of vertexs which in turn makes a 2 dimensional array in which the indexes are vertexes and the values in the graph are distances

The algorithm takes a parameter of a NodeDistance of the previous node, and run through that to check for possible routes to other nodes and if the node it
finds is unexplored, it adds that to the min heap with the coorelating total distance and adds the node to a linkedlist of type NodeDistance. 
Then, it checks the if the values from the nds == the minimum value of the minHeap, and if it does it adds it to the finalPath, and reruns the algorithm
with passing the previous node distance

SSAD contains the main method to run the program
