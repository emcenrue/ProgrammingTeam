package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;



/**
 * Kattis
 * Round 5
 * Division 2
 * Problem C
 * @author Edward McEnrue
 */
public class Flexible_Spaces {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int w = in.nextInt();
		int p = in.nextInt();
		
		
		HashMap<Integer, Boolean> room = new HashMap<Integer, Boolean>();
		
		int[] parts = new int[p+2];
		
		parts[0] = 0;
		
		for(int i = 1; i < p+1; i++)
		{
			parts[i] = in.nextInt();
		}
		room.put(w, true);
		parts[p+1] = w;
		
		
		
		for(int i = 0; i < parts.length; i++)
		{
			for(int j = 0; j < parts.length; j++)
			{
				room.put(parts[j] - parts[i], true);
			}
		}
		
		
		
		for(int i = 1; i < w+1; i++)
		{
			if(room.get(i) != null && room.get(i))
			{
				if(i == w)
				{
					System.out.print(i+"");
				}
				else
				{
					System.out.print(i+" ");
				}
				
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
