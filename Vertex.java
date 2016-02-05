
public class Vertex {

	private String name;
	private int id;
	
	public Vertex(int id, String name) {
		this.id=id;
		this.name=name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "<"+name+">";
	}
	
}
