package graph;

public class Edge {
	
	private final Node source;
	private final Node destination;
	private final int weigth;
	
	public Edge(Node source, Node destination, int weigth) {
		this.source = source;
		this.destination = destination;
		this.weigth = weigth;
	}

	public Node getSource() {
		return source;
	}

	public Node getDestination() {
		return destination;
	}

	public int getWeigth() {
		return weigth;
	}

	@Override
	public int hashCode() {
		return source.hashCode() + destination.hashCode() + weigth;
	}

	@Override
	public boolean equals(Object obj) {
		Edge otherEdge = null;
		if (obj instanceof Edge) {
			otherEdge = (Edge)obj;
		} else {
			return false;
		}
		
		Node otherSource = otherEdge.getSource();
		Node otherDest = otherEdge.getDestination();
		int otherWeight = otherEdge.getWeigth();
		
		return (otherSource.equals(source) && otherDest.equals(destination)
				&& otherWeight == weigth);
		
	}
	
	

}
