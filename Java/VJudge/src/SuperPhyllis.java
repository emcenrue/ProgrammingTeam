import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.w3c.dom.Node;



/**
 * Codeforces.com 
 * Round ICPC ACM 
 * Division 2
 * Problem F
 * @author Edward McEnrue
 */
public class SuperPhyllis {

	static HashMap<Node, ArrayList<Node>> graph = new HashMap<Node, ArrayList<Node>>();
	static ArrayList<Pair> removedEdges = new ArrayList<Pair>();
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int m = in.nextInt();
		while(true){
			if(m == 0) break;
			//=======Constructs the graph=======
			for(int z = 0; z < m; z++){
				String sn1 = in.next();
				Node n1 = new Node(sn1);
				String sn2 = in.next();
				Node n2 = new Node(sn2);
				
				ArrayList<Node> curAdj = graph.get(n1);
				if(curAdj == null){
					curAdj = new ArrayList<Node>();
					curAdj.add(n2);
					graph.put(n1, curAdj);
				}else{
					curAdj.add(n2);
					graph.put(n1, curAdj);
				}
			}//=================================
			
			//Go through each node and get an adjacency
			for(Node n : graph.keySet()){
				solve(n, graph.get(n));
			}
			
			Collections.sort(removedEdges, new PairComparator());
			
			m = in.nextInt();
		}	
	}
	
	/** BFS Skeleton.
	 * Assumes that 'State' implements equals() and hashCode()
	 * according to contract.
	 * State must also provide 'isfinal', and 'successors' methods
	 */
	static void solve(Node n, ArrayList<Node> adjToN) {
		
	}
	/**
	 * will need to implement equals and hashcode
	 * @author emcenrue
	 *
	 */
	public static class Node{
//		ArrayList<Node> adj;
		String name;
		
		public Node(String s){
			this.name = s;
		}
//		public void addAdjacency(Node n){
//			adj.add(n);
//		}
	}
	
	public static class Pair{
		Node n1;
		Node n2;
		public Pair(Node n1, Node n2){
			this.n1 = n1;
			this.n2 = n2;
		}

	}
	
	public static class PairComparator implements Comparator<Pair>{
		
		@Override
		public int compare(Pair p1, Pair p2) {
			
			int firstComparison = p1.n1.name.compareTo(p2.n1.name);
			if(firstComparison == 0){
				int secondComparison = p1.n2.name.compareTo(p2.n2.name);
				return secondComparison;
			}
			else{
				return firstComparison;
			}
		}
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
