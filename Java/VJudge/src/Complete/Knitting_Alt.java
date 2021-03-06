package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/**
 * Codeforces.com 
 * Round 3
 * Division 2
 * Problem A
 * @author Edward McEnrue
 */
public class Knitting_Alt {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		while(n != 0 || m != 0 || k != 0)
		{

			int[] r = new int[k];
			for(int i = 0; i < k; i++)
			{
				r[i] = in.nextInt();
			}
			
			int total = n;
			int diff = 0;
			
			for(int j = 0; j < m-1; j++)
			{
				diff += r[j%k];
				total += n + diff;
			}
			
			System.out.println(total);
			
			n = in.nextInt();
			m = in.nextInt();
			k = in.nextInt();
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
