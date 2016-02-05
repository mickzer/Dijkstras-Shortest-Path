
public class CostAndSource {

	private int cost;
	private Vertex source;
	
	public CostAndSource(int cost, Vertex source) {
		this.cost=cost;
		this.source=source;
	}
	
	public int getCost() {
		return cost;
	}
	
	public Vertex getSource() {
		return source;
	}
	
}
