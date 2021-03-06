import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.omg.PortableServer.POAManagerPackage.State;

import Utilities.IO_Template.MyScanner;


/**
 * vjudge.com 
 * TeamRound 2
 * Division 2
 * Problem C
 * @author Edward McEnrue
 */
public class Dungeon_Master {
	
	static char[][][] cube;
	static int l;
	static int r;
	static int c;
	
	
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		l = in.nextInt();
		r = in.nextInt();
		c = in.nextInt();
		
		cube = new char[l][r][c];
		
		while(l+r+c != 0)
		{
			State start = null;
			
			for(int i = 0; i < l; i++)
			{
				for(int j = 0; j < r; j++)
				{
					String row = in.nextLine();
					for(int k = 0; k < c; k++)
					{
						cube[i][j][k] = row.charAt(k);
						if(cube[i][j][k] == 'S')
							start = new State(i,j,k);
					}
				}
				in.nextLine();
			}
		}
		
		solve(start);
		
		l = in.nextInt();
		r = in.nextInt();
		c = in.nextInt();
		cube = new char[l][r][c];

	}
	
	
	
	
	/** BFS Skeleton.
	 * Assumes that 'State' implements equals() and hashCode()
	 * according to contract.
	 * State must also provide 'isFinal', and 'successors' methods
	 * 
	 * NOTES--------------------------------------------------------------
	 * Using a FIFO queue, BFS queues up a node, searches all of that nodes 
	 * neighbors (queuing them up subsequently), and then removes the first 
	 * node from the queue. Rinse wash repeat for the next node in the queue.
	 * 
	 * Based on the above description, BFS will traverse a graph based on
	 * the distance from the start node, so it will visit all nodes
	 * distance 1 from the start node, then distance 2, then 3, etc.
	 * Therefore, by going backwards in the queue from the destination node
	 * you can reconstruct the shortest path back to the start.
	 * 
	 * BFS acquires the shortest path in an unweighted graph.
	 * -------------------------------------------------------------------
	 */
	void solve(State start) {
	    Set<State> visited = new HashSet<State>();                  
	    // has this state been visited?
	    Map<State, State> pred = new HashMap<State, State>();       
	    // predecessor on the shortest path to the start state
	    Map<State, Integer> dist = new HashMap<State, Integer>();   
	    // shortest distance to start state
	    Deque<State> bfs = new ArrayDeque<State>();  // BFS queue
	    bfs.offer(start);
	    dist.put(start, 0);
	    
	    boolean reached = false; //=========ADDED4DMASTER==========
	    int min = Integer.MAX_VALUE; //=========ADDED4DMASTER==========

	    while (bfs.size() > 0) {
	        State s = bfs.poll();
	        int n = dist.get(s);
	        visited.add(s);

	        if (s.isFinal()) {
	        	
	        	if(n < min) //=========ADDED4DMASTER==========
	        	{
	        		min = n;
	        	}
	        	reached = true; //=========ADDED4DMASTER==========
	        	break; //=========ADDED4DMASTER==========
	        }

	        for (State succ : s.successors()) {
	            if (visited.contains(succ))
	                continue;

	            if (!pred.containsKey(succ)) //this is why you need hashcode
	                pred.put(succ, s);

	            if (!dist.containsKey(succ)) {
	                dist.put(succ, n+1);
	                bfs.offer(succ);
	            }
	        }
	    }
	    
	    if(reached) //=========ADDED4DMASTER==========
	    {
	    	System.out.println("Escaped in "+min+" minute(s).");
	    }
	    else
	    {
	    	System.out.println("Trapped!");
	    }
	}
	
	//==========================UNUSED4DMASTER====================================
	/* Compute and output path */
	void output(int distToSolution, State finalState, Map<State, State> pred) {
	    System.out.println("The distance to the solution is: " + distToSolution);

	    List<State> revPath = new ArrayList<State>();
	    State s = finalState;
	    while (pred.containsKey(s)) {
	        revPath.add(s);
	        s = pred.get(s);
	    }
	    revPath.add(s);

	    for (int i = 0; i < revPath.size(); i++) {
	        System.out.printf("%3d %s%n", i, revPath.get(revPath.size() - 1 - i));
	    }
	}
	//==========================UNUSED4DMASTER====================================
	
	/**
	 * NOTES-------------------------------------------------
	 * successors() are all adjacent possible moves to the current node
	 * stored in a list, so in the cube, its going up or down a level, 
	 * left right up and down in the current level.
	 * 
	 * State is actually another name for a node.
	 * 
	 * 
	 * ------------------------------------------------------
	 * @author emcenrue
	 * must implement equals(), hashCode(), ifFinal(), and successors()
	 */
	public static class State
	{
		int x;
		int y;
		int level;
		
		public State(int x, int y, int level)
		{
			this.x = x;
			this.y = y;
			this.level = level;
		}
		
		@Override
		public boolean equals(Object o)
		{
			State s = (State)o;
			return this.x == s.x && this.y == s.y && this.level == s.level;
		}
		
		public List<State> successors()
		{
			List<State> list = new ArrayList<State>(); //adjacent nodes list
			
			if(this.level > 0 && cube[level -1][x][y] != '#')
			{
				list.add(new State(level - 1, x, y));
			}
			if(this.level < l && cube[level+1][x][y] != '#')
			{
				list.add(new State(level +1, x, y));
			}
			if(this.x > 0 && cube[level][x-1][y] != '#')
			{
				list.add(new State(level, x-1, y));
			}
			if(this.x+1 < r && cube[level][x+1][y] != '#')
			{
				list.add(new State(level, x+1, y));
			}
			if(this.y > 0 && cube[level][x][y-1] != '#')
			{
				list.add(new State(level, x, y-1));
			}
			if(this.y + 1 < c && cube[level][x][y+1] != '#')
			{
				list.add(new State(level, x, y+1));
			}
			
		}
		
		public boolean isFinal()
		{
			return cube[level][x][y] == 'E';
		}
		
		//I don't understand this but
		// guaranteed a unique hash code for each state
        // b/c max of 30 for each l, x, and y
		public int hashCode()
		{
			return 900 * l + 30 * x + y;
		}
	}
	
	// -----------Pair class for comparisons-------------
	public static class Pair implements Comparable<Pair> {
	    int x, y;
	    Pair(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	    @Override
	    public int compareTo(Pair o)
	    {
	    	return Integer.compare(this.x, o.x);
	    }
	    @Override
	    public boolean equals(Object o) {
	        Pair p = (Pair)o;
	        return this.x == p.x && this.y == p.y;
	    }
	    @Override
	    public int hashCode() {
	        return x ^ y;
	    }
	}
	// -------------------------------------------------
	
	
	

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
