

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * SD2x Homework #6
 * This is an implementation of Depth First Search (DFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class DepthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;
	//protected List<Node> path = new LinkedList<Node>();
	protected List<Node> path = new LinkedList<Node>();
	protected List<List<Node>> pathList = new LinkedList<List<Node>>();
	protected Node init;


	
	public DepthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
	}
	
	public void dfs(Node start) {
		if (!graph.containsNode(start)) {
			return;
		}	
	
		marked.add(start);
		path.add(start);
		pathList.add(new LinkedList<>(path));
		Set<Node> aux = graph.getNodeNeighbors(start);
		if (graph.getNodeNeighbors(start).isEmpty()) {
			path.remove(start);
		} else {
			for (Node neighbor : graph.getNodeNeighbors(start)) {
				if (!marked.contains(neighbor)) { 
				    dfs(neighbor);
				}
				
			}
		}
	}
	
	
	public List<List<Node>> getPathList() {
		return pathList;
	}
	
	public static void main(String[] args) {
		
		Graph grafo = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
			
		//Graph grafo = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
		
		DepthFirstSearch dfs = new DepthFirstSearch(grafo);
		dfs.dfs(grafo.getNode("1"));
		
		List<List<Node>> saida = dfs.getPathList();
		saida.forEach(r -> System.out.println(r));
	}
}
