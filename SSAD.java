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

public class SSAD {

	static Graph graph = null;
	static DjikstraTable dT = null;

	public static void main(String[] args) throws Exception {
		// Creating inputFile
		RandomAccessFile inputFile = new RandomAccessFile(args[0], "r");
		// Creating outputFile
		RandomAccessFile outputFile = new RandomAccessFile(args[1], "rw");

		// Writing the first part the output file
		outputFile.writeBytes("Node | Successor\n");
		outputFile.writeBytes("----------------------------------------------------------------------\n");

		// Grabbing the amount of vertices and the start vertex
		String inputStr = inputFile.readLine();
		String[] split = inputStr.split(": ");
		int vertices = Integer.parseInt(split[1]);

		inputStr = inputFile.readLine();
		split = inputStr.split(":");
		int startVertex = Integer.parseInt(split[1].trim());

		graph = new Graph(vertices, startVertex);

		// Reads the blank line
		inputStr = inputFile.readLine();
		// Reads the top section with the nodes it goes to
		inputStr = inputFile.readLine();
		inputStr = inputFile.readLine();
		inputStr = inputFile.readLine();

		int vertex = 0;
		while (inputStr != null) {
			Vertex vert = new Vertex();
			outputFile.writeBytes("\t" + vertex + " |\t");
			inputStr = inputStr.substring(inputStr.indexOf("|") + 1);
			// split = inputStr.substring(beginIndex);
			String[] distances = inputStr.split("   ");
			// System.out.print("[");
			for (int i = 1; i < distances.length; i++) {
				int distance = Integer.parseInt(distances[i].trim());
				vert.add(distance);
				// Writing the paths to the output file
				if (distance == 0) {
					continue;
				} else {
					int node = i - 1;
					outputFile.writeBytes(node + ": " + distance + "\t");
				}
			}

			graph.addVertex(vert);
			// System.out.print("]");
			// System.out.println();
			outputFile.writeBytes("\n");
			vertex++;
			inputStr = inputFile.readLine();
		}

		// graph.displayTable();
		dT = new DjikstraTable(graph);
		// System.out.println(table.table.get(5).distances.get(0));

		// System.out.println(startVertex);
		// dT.alg(startVertex, 0);
		dT.addStart(new NodeDistance(startVertex, 0));
		dT.alg(new NodeDistance(startVertex, 0));
		// System.out.println("node " + startVertex + ": " + 0);
		outputFile.writeBytes("\n");
		outputFile.writeBytes(" Start vertex is: " + startVertex + "\n\n");
		outputFile.writeBytes("Dest | Total Weight | Path\n");
		outputFile.writeBytes("Dest | Total Weight | Path\n");
		outputFile.writeBytes("----------------------------------------------------------------------\n");
		dT.printAlg(outputFile);
	}

}
