

import java.util.List;
import java.util.Set;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {
		
		if (graph == null || graph.getAllNodes().isEmpty()) {
			return -1;
		}
		
		if (src == null || src.isEmpty()) {
			return -1;
		}
		if (dest == null || dest.isEmpty()) {
			return -1;
		}
		
		if (!graph.containsElement(src) || !graph.containsElement(dest)) {
			return -1;
		}
		
		Node startNode = graph.getNode(src);
		
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
		int shortestPath = bfs.bfs(startNode, dest);
		
		
		return shortestPath;
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it
	}


	public static boolean isHamiltonianPath(Graph g, List<String> values) {

		/* IMPLEMENT THIS METHOD! */
		
		return true; // this line is here only so this code will compile if you don't modify it
	}
	
}
