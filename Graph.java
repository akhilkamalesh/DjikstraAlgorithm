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
import java.io.*;

// Table will hold the distances for the algorithm
public class Graph {

	ArrayList<Vertex> table;
	int size;
	int start;

	/**
	 * Constructor for graph class
	 * 
	 * @param sz
	 * @param st
	 */
	public Graph(int sz, int st) {
		table = new ArrayList<Vertex>();
		size = sz;
		start = st;
	}

	// add vertex
	public void addVertex(Vertex vert) {
		table.add(vert);
	}

	// displayTable
	public void displayTable() {
		for (int i = 0; i < table.size(); i++) {
			System.out.print("[");
			table.get(i).display();
			System.out.print("]");
			System.out.println();
		}
	}

	// getStart
	public int getStart() {
		return start;
	}

	// getVertex
	public Vertex getVertex(int index) {
		return table.get(index);
	}
}
