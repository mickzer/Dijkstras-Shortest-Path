import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;

public class Dijkstras {

	private ArrayList<Vertex> vertexes;
	private ArrayList<Edge> edges;
	private Set<Vertex> unvisited;
	private HashMap<Vertex, CostAndSource> distances;
	private Vertex start;
	
	public Dijkstras(Graph g) {
		vertexes = new ArrayList<Vertex>(g.getVertexes());
		edges = new ArrayList<Edge>(g.getEdges());
	}
	
	public Integer getDistance(Vertex a, Vertex b) {
		for(Edge e : edges) {
			if(e.connects(a, b))
				return e.getCost();
		}
		return null; //not edge exists
	}
	
	public Vertex getLowestUnvisited() {
		if(unvisited.isEmpty())
			return null;
	
		Vertex x=unvisited.iterator().next();
		int lowest = distances.get(x).getCost();
		for(Vertex v : unvisited) {
			int tmp = distances.get(v).getCost();
			if(tmp < lowest) {
				lowest = tmp;
				x=v;
			}
		}
		return x;
	}
	
	private void computeDistances() {
		
		unvisited = new HashSet<Vertex>();
		for(Vertex v : vertexes)
			unvisited.add(v);
		distances = new HashMap<Vertex, CostAndSource>();
		for(Vertex v : vertexes)
			distances.put(v, new CostAndSource(Integer.MAX_VALUE, null));
		
		//set start distance to 0
		distances.put(start, new CostAndSource(0, null));
		Vertex current = start;
		//go through all unvisited nodes
		while(!unvisited.isEmpty()) {
			//mark vertex as visited
			unvisited.remove(current);
			//go through all the remaining unvisited
			for(Vertex v : unvisited) {
				//compute distance from current to v
				Integer d = getDistance(current, v);
				if(d != null) {
					//add the currently accumulated cost from current
					d += distances.get(current).getCost();
					//update table if new cost is less than what's currently available
					if(d < distances.get(v).getCost())
						distances.put(v, new CostAndSource(d, current));

				}
			}
			//pick the lowest unvisisted
			current = getLowestUnvisited();
		}
				
	}
	
	public void printDistanceTable() {
		String line ="";
		for(Vertex v : distances.keySet()) {
			System.out.print(v+"\t");
			CostAndSource c = distances.get(v);
			line += c.getSource()+"|"+c.getCost()+"\t";
		}
		System.out.println("\n"+line+"\n");
	}
	
	public ArrayList<Vertex> shortestPath(Vertex start, Vertex dest) {
		if(this.start != start) {
			this.start = start;
			computeDistances();
		}
		
		Stack<Vertex> path = new Stack<Vertex>();
		//get the destination node in the distance table
		Vertex current = dest;
		while(current != null) {
			path.push(current);
			current = distances.get(current).getSource();
		}
		ArrayList<Vertex> output = new ArrayList<Vertex>();
		while(!path.isEmpty())
			output.add(path.pop());
		return output;
	}
		
	
}
