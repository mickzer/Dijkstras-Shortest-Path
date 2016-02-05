import java.util.ArrayList;

public class Test {

	public static void test1() {
		Graph g = new Graph();
		
		Vertex A = g.addVertex("A");
		Vertex B = g.addVertex("B");
		Vertex C = g.addVertex("C");
		Vertex D = g.addVertex("D");
		Vertex E = g.addVertex("E");
		
		g.addEdge(A, B, 4);
		g.addEdge(A, C, 2);
		
		g.addEdge(B, C, 3);
		g.addEdge(B, D, 2);
		g.addEdge(B, E, 3);
		
		g.addEdge(C, B, 1);
		g.addEdge(C, D, 4);
		g.addEdge(C, E, 5);
		
		g.addEdge(E, D, 1);
		
		Dijkstras d = new Dijkstras(g);
		ArrayList<Vertex> path  = d.shortestPath(A, E);
		for(int i=0; i<path.size(); ++i)
			System.out.print(path.get(i) + ((path.size()-1!=i)?"->":""));
		System.out.println();
	}
	
	public static void test2() {
		Graph g = new Graph();
		
		Vertex A = g.addVertex("A");
		Vertex B = g.addVertex("B");
		Vertex C = g.addVertex("C");
		Vertex D = g.addVertex("D");
		Vertex E = g.addVertex("E");
		Vertex Z = g.addVertex("Z");
		
		g.addEdge(A, B, 2);
		g.addEdge(A, C, 3);
		
		g.addEdge(B, C, 6);
		g.addEdge(B, D, 5);
		g.addEdge(B, E, 3);
		
		g.addEdge(C, E, 1);
		
		g.addEdge(D, E, 1);
		g.addEdge(D, Z, 2);
		
		g.addEdge(E, Z, 4);
		
		Dijkstras d = new Dijkstras(g);
		ArrayList<Vertex> path  = d.shortestPath(A, Z);
		for(int i=0; i<path.size(); ++i)
			System.out.print(path.get(i) + ((path.size()-1!=i)?"->":""));
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		test1();
		test2();
	}
	
	
}
