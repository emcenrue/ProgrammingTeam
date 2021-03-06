import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round WarmUp
 * Division 2
 * Problem C
 * @author Edward McEnrue
 */
public class CFTeamWarmUp_GPS_Routing_Small {

	
	//read handbook
	
//	/**
//	 * 
//	 * @author emcenrue
//	 */
//	static class Graph
//	{
//		HashMap<String, Vert> graph = new HashMap<String, Vert>();
//	} useless class is useless i hope shiiii
	
	/**
	 * A vertex with a town name and position coordinates.
	 * @author emcenrue
	 */
	static class Vert
	{
		int x;
		int y;
		String name;
		ArrayList<Edge> roads = new ArrayList<Edge>();
		double shortestDistance = Double.POSITIVE_INFINITY; //This helps with d's algo as it changes this var to be the dist from src along a path.
		boolean visited = false;//This also helps with d's algo and checking if the node/vertex/town has been visited.
		

		Vert(String name, int x, int y)
		{
			this.x = x;
			this.y = y;
			this.name = name;
		}
		
		public void addRoad(Edge neighbor)
		{
			roads.add(neighbor);
		}
		
		public double getDistance() {
			return shortestDistance;
		}

		public void setDistance(double distance) {
			this.shortestDistance = distance;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}
	}
	
	/**
	 * An edge with a destination town and the edge's weight.
	 * @author emcenrue
	 */
	static class Edge
	{
		String destTown;
		
		double weight;
		
		Edge(String to, double weight)
		{
			this.destTown = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int n = in.nextInt(); // nTowns
		int m = in.nextInt(); // mRoads
		int q = in.nextInt(); // qQueries
		
		HashMap<String, Vert> townMap = new HashMap<String, Vert>();
		
		//Adds all the towns to the hashmap
		for(int i = 0; i < n; i++)
		{
			String townName = in.next();
			int x = in.nextInt();
			int y = in.nextInt();
			
			Vert town = new Vert(townName, x, y);
			
			townMap.put(townName, town);
		}
		
		//give all the towns their roads to neighbors
		for(int i = 0; i < m; i++)
		{
			String town1 = in.next();
			String town2 = in.next();
			double roadWeight = in.nextDouble();
			
			Edge roadFromTown1 = new Edge(town2, roadWeight);
			Vert t1 = townMap.get(town1);
			t1.addRoad(roadFromTown1);
			
			Edge roadFromTown2 = new Edge(town1, roadWeight);
			Vert t2 = townMap.get(town2);
			t2.addRoad(roadFromTown2);
		}
		
		//begin d's Algo and process each query
		for(int i = 0; i < q; i++)
		{
			String src = in.next();
			String dest = in.next();
			dAlgo(townMap.get(src), townMap.get(dest), townMap);
		}
		
		//done-zoh
	}
	
	/**
	 * Finds the shortest path from the starting town to the destination town.
	 * Prints the path length, and then the visited vertices from start to finish.
	 * 
	 * @param src starting town/vertex in the map
	 * @param dest destination town/vertex in the map
	 * @param tMap The holy map
	 */
	private static void dAlgo(Vert src, Vert dest, HashMap<String, Vert> tMap)
	{
		src.setDistance(0); // the distance from the start to the start is 0.
		src.setVisited(true); //It has been visited
		//still need to have data structure for holding visited nodes
	}
	
	
	

	// -----------MyScanner class for faster input----------
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}
	// --------------------------------------------------------
}
