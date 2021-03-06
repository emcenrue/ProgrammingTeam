import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Utilities.Pair;


/**
 * Codeforces.com 
 * Round 5
 * Division 2
 * Problem G
 * @author Edward McEnrue
 */
public class Pesky_Mosquitoes {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int n = in.nextInt();
		
		for(int z = 0; z < n; z++)
		{
			int m = in.nextInt();
			double d = in.nextDouble();
			
			Pair[] pairs = new Pair[m];
			
			for(int i = 0; i < m; i++)
			{
				double x = in.nextDouble();
				double y = in.nextDouble();
				
				Pair mos = new Pair(x, y);
				
				pairs[i] = mos;
			}
			int count = 0;
			for(int i = 0; i < m; i++)
			{
				for(int j = 0; j < m; j++)
				{
					//(x - center_x)^2 + (y - center_y)^2 < radius^2
					//t
					if(pairs[j])
				}
			}
			System.out.println(count);
		}
	}
	
	public static class Pair implements Comparable<Pair> {
	    double x;
		double y;
	    Pair(double x2, double y2) {
	        this.x = x2;
	        this.y = y2;
	    }
	    @Override
	    public int compareTo(Pair o)
	    {
	    	return Double.compare(this.x, o.x);
	    }
	    @Override
	    public boolean equals(Object o) {
	        Pair p = (Pair)o;
	        return this.x == p.x && this.y == p.y;
	    }
	    @Override
	    public int hashCode() {
	        return (int)x ^ (int)y;
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
