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

public class Vertex {

	ArrayList<Integer> distances;

	// Constructor for vertex
	public Vertex() {
		distances = new ArrayList<Integer>();
	}

	// add distances to vertex
	public void add(int distance) {
		distances.add(distance);
	}

	// display vertex
	public void display() {
		for (int i = 0; i < distances.size(); i++) {
			System.out.print(distances.get(i) + ", ");
		}
	}

	// get the size of vertex
	public int getSize() {
		return distances.size();
	}

	// gets a specific distance from vertex
	public int getDistance(int index) {
		return distances.get(index);
	}
}
