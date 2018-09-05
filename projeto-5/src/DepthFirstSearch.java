

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
 * SD2x Homework #6
 * This is an implementation of Depth First Search (DFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class DepthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;
	//protected List<Node> path = new LinkedList<Node>();
	protected Stack<Node> path = new Stack<Node>();
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
		path.push(start);
		pathList.add(copyStack(path));
		for (Node neighbor : graph.getNodeNeighbors(start)) {
			if (!marked.contains(neighbor)) { 
			    dfs(neighbor);
			}
			
		}
	}
	
	private List<Node> copyStack(Stack<Node> stack) {
		
		List<Node> lista = new ArrayList<Node>(stack.size());
		stack.forEach(node -> {
			Node newNode = new Node(node.getElement());
			lista.add(newNode);
		});
		
		return lista;
	}
	
	public List<List<Node>> getPathList() {
		return pathList;
	}
	
	public static void main(String[] args) {
		
		Graph undirect = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
			
		DepthFirstSearch dfs = new DepthFirstSearch(undirect);
		dfs.dfs(undirect.getNode("1"));
		
		List<List<Node>> saida = dfs.getPathList();
		saida.forEach(r -> System.out.println(r));
	}
}
