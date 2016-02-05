import java.util.ArrayList;

public class Graph {

	private int nextVertexId;
	private ArrayList<Vertex> vertexes;
	private ArrayList<Edge> edges;
	
	public Graph() {
		nextVertexId=0;
		vertexes=new ArrayList<Vertex>();
		edges=new ArrayList<Edge>(); 
	}
	
	public Vertex addVertex(String name) {
		if(name == null) 
			throw new NullPointerException("vertex name must not be null");
		if(name.length() == 0) 
			throw new IllegalArgumentException("vertex name must be at least 1 character");
		Vertex v = new Vertex(nextVertexId++, name);
		vertexes.add(v);
		return v;
	}
	
	public Edge addEdge(Vertex a, Vertex b, int cost) {
		if(a == null || b == null) 
			throw new NullPointerException("vertexes must not be null");
		if(!vertexes.contains(a) || !vertexes.contains(b)) 
			throw new IllegalArgumentException("vertexes must be in this graph");
		if(a.equals(b)) 
			throw new IllegalArgumentException("vertexes must not be the same");
		Edge e = new Edge(a, b, cost);
		edges.add(e);
		return e;
	}
	
	public ArrayList<Vertex> getVertexes() {
		return vertexes;
	}
	
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	
}
