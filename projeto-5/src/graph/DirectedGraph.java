package graph;

public class DirectedGraph extends Graph {
	
	public DirectedGraph() {
		super();
	}

	@Override
	public boolean addEdge(Node node1, Node node2, int weight) {
		addNode(node1);
		addNode(node2);
		boolean addEdgeSuccess = addEdgeFromTo(node1, node2, weight);
		if (addEdgeSuccess) {
			numEdges++;
		}
		return addEdgeSuccess;
	}

	@Override
	public boolean removeEdge(Node node1, Node node2, int weight) {
		// TODO Auto-generated method stub
		return false;
	}

}
