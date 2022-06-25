// On my honor:
//
// - I have not discussed the Java language code in my program with
// anyone other than my instructor or the teaching assistants
// assigned to this course.
//
// - I have not used Java language code obtained from another student,
// or any other unauthorized source, including the Internet, either
// modified or unmodified.
//
// - If any Java language code or documentation used in my program
// was obtained from another source, such as a text book or course
// notes, that has been clearly noted with a proper citation in
// the comments of my program.
//
// - I have not designed this program in such a way as to defeat or
// interfere with the normal operation of the supplied grading code.
//
// Akhil Kamalesh
// akhilk24@vt.edu

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DjikstraTable {

	Graph graph;
	LinkedList<NodeDistance> nds;
	BinaryHeap<Integer> minHeap;
	ArrayList<NodeDistance> finalPath; // Switched from NodeDistance
	// Boolean[] check;
	ArrayList<Integer> checkVertex;

	public DjikstraTable(Graph g) {
		graph = g;
		minHeap = new BinaryHeap(graph.size);
		nds = new LinkedList<NodeDistance>();
		finalPath = new ArrayList<NodeDistance>();
		checkVertex = new ArrayList<Integer>(); // Want to make it so that it won't visit
	}

	// Adds the starting node to the path
	public void addStart(NodeDistance start) {
		finalPath.add(start); // Adding the starting node to the final path
		checkVertex.add(start.getVertex()); // Adding the starting vertex to check
	}

	// Prints the algorithm
	public void printAlg(RandomAccessFile output) throws IOException {
		ArrayList<Integer> outputChecker = new ArrayList<Integer>();

		for (int i = 0; i < finalPath.size(); i++) {

			if (!outputChecker.contains(finalPath.get(i).getVertex())) {

				outputChecker.add(finalPath.get(i).getVertex());
			} else {
				continue;
			}
		}

		for (int i = 0; i < outputChecker.size(); i++) {

			ArrayList<Integer> pathChecker = new ArrayList<Integer>();

			int index = finalPath.indexOf(new NodeDistance(i, -100));

			output.writeBytes("\t" + i + " |\t" + finalPath.get(index).getDistance() + "  |\t");
			// + finalPath.get(index).returnPaths());
			for (int j = 1; j < finalPath.get(index).returnPaths().size(); j++) {
				if (!pathChecker.contains(finalPath.get(index).returnPaths().get(j))) {
					pathChecker.add(finalPath.get(index).returnPaths().get(j));
					output.writeBytes(finalPath.get(index).returnPaths().get(j).toString() + " ");
				} else {
					// System.out.println("Caught");
				}
			}
			output.writeBytes("\n");
		}

	}

	// Recursive algorithm that uses Djikstra's
	public void alg(NodeDistance prev) throws Exception {
		int vertInd = prev.getVertex(); // grabbing vertex from prev
		int distance = prev.getDistance(); // grabbing distance from prev
		// System.out.println(prev.returnPaths());
		Vertex vertex = graph.getVertex(vertInd); // grabbing the vertex from the position
		NodeDistance nodeDist = null;

		boolean x = false;

		for (int i = 0; i < vertex.getSize(); i++) { // Iterating through the Vertex
			if (vertex.getDistance(i) == 0) { // If 0, then skip
				continue;
			} else {
				x = true;
				// NodeDistance check = new NodeDistance(i, vertex.getDistance(i));
				nodeDist = new NodeDistance(prev, vertex.getDistance(i) + distance, i);
				// System.out.println(prev.returnPaths());
				// System.out.println(nodeDist.returnPaths());

				// Checking to make sure the paths we are taking is not to a explored node
				if (!checkVertex.contains(i)) {
					// nodeDist.addVertexToPath(i);
					nds.add(nodeDist); // Adding the nodeDist to the linkedList
					// System.out.println(nds);
					// nodeDist.addVertexToPath(i); // Adding the vertex to the path now
					minHeap.insert(nodeDist.getDistance()); // Inserting the distance to the minHeap
					// } else {
					// System.out.println("Node " + i + " has been visited");
				}
			}
		}

		for (int j = 0; j < nds.size(); j++) {
			if ((nds.get(j).getDistance() == minHeap.findMin())) {

				minHeap.deleteMin(); // Deletes the min distance from the heap
				int retVertex = nds.get(j).getVertex(); // Stores the vertex into a variable
				int retDistance = nds.get(j).getDistance(); // Stores the distance into a variable
				ArrayList<Integer> arrList = nds.get(j).returnPaths();
				// System.out.println("Node " + retVertex + " has been added");

				// Checks to see if it is already in check Vertex (error checking)
				// if (!checkVertex.contains(retVertex)) {
				checkVertex.add(retVertex);
				// } else {
				// }

				// nds.get(j).addVertexToPath(5);
				// System.out.println(nds.get(j).returnPaths());
				finalPath.add(nds.get(j)); // Adds the node distance to the path
				nds.remove(j); // removing the NodeDistance that is added to the final path
				// alg(nds.get(j));
				// System.out.println(nodeDist.getVertex());
				alg(new NodeDistance(arrList, retVertex, retDistance));
			}
		}

//		if (!x) {
//			System.out.println("no path");
//			return;
//		}

		// Base case
		if (minHeap.isEmpty()) {
			// System.out.println("-------");
			return;
		}
	}
}
