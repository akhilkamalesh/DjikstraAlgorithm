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

import java.util.ArrayList;

public class NodeDistance {

	int vertInd;
	int distance;
	ArrayList<Integer> paths;

	// Constructor for NodeDistance class
	public NodeDistance(int v, int d) {
		vertInd = v;
		distance = d;
		paths = new ArrayList<Integer>();
		paths.add(v);
	}

	// Second constructor takes in arraylist as well for the paths
	public NodeDistance(ArrayList<Integer> arr, int v, int d) {
		vertInd = v;
		distance = d;
		paths = new ArrayList<Integer>();
		for (int i = 0; i < arr.size(); i++) {
			paths.add(arr.get(i));
		}
		paths.add(v);
	}

	// Third constructor, takes in another node
	public NodeDistance(NodeDistance nd, int distance, int vertex) {
		vertInd = vertex;
		this.distance = distance;
		paths = new ArrayList<Integer>();
		for (int i = 0; i < nd.returnPaths().size(); i++) {
			paths.add(nd.returnPaths().get(i));
		}
		paths.add(vertex);
	}

	// get vertex
	public int getVertex() {
		return vertInd;
	}

	// sets the vertex
	public void setVertex(int v) {
		vertInd = v;
	}

	// get the distance
	public int getDistance() {
		return distance;
	}

	// set distance
	public void setDistance(int d) {
		distance = d;
	}

	// return the paths connected to the node
	public ArrayList<Integer> returnPaths() {
		return paths;
	}

	// adds the paths connected to the node
	public void addVertexToPath(int vert) {
		paths.add(vert);
	}

	// equal method
	public boolean equals(Object o) {
		NodeDistance other = (NodeDistance) o;
		if (this.getVertex() == other.getVertex()) {
			return true;
		}
		return false;
	}
}
