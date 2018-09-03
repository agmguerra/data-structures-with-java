package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
	
	private Set<Node> marked;
	private Graph graph;
	
	public BreadthFirstSearch(Graph graphToSearch) {
		this.marked = new HashSet<>();
		this.graph = graphToSearch;
	}
	
	public boolean bfs(String elementToFind, Node start) {
		if (!graph.containsNode(start)) {
			return false;
		}
		
		if (start.getElement().equals(elementToFind)) {
			return true;
		}
		
		Queue<Node> toExplore = new LinkedList<Node>();
		
		marked.add(start);
		toExplore.add(start);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					if (neighbor.getElement().equals(elementToFind)) {
						return true;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
				
			}
		}
		return false;
	}

}
