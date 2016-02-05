
public class Edge {
	private Vertex a;
	private Vertex b;
	private int cost;
	
	public Edge(Vertex a, Vertex b, int cost) {
		if(a == null || b == null)
			throw new NullPointerException("start and dest vertexes must not be null");
		this.a=a;
		this.b=b;
		this.cost=cost;
	}
	
	public Vertex[] getVertexes() {
		return new Vertex[]{a, b};
	}
	
	public boolean connects(Vertex a, Vertex b) {
		if((this.a.equals(a) && this.b.equals(b)) || 
		   (this.a.equals(b) && this.b.equals(a)))
			return true;
		return false;
	}
	
	public int getCost() {
		return cost;
	}
	
}
