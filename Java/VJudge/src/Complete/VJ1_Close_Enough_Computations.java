package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Vjudge.net
 * Round 1
 * Division 2
 * Problem C
 * @author Edward McEnrue
 */
public class VJ1_Close_Enough_Computations {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		double c = in.nextDouble();
		double f = in.nextDouble();
		double carb = in.nextDouble();
		double p = in.nextDouble();
		while( c != 0 || f != 0 || carb != 0 || p != 0)
		{
			
			
			double max = (f+.49999999)*9+(carb+.49999999)*4+(p+.49999999)*4;
			
			double min = Math.max(f-.4999999, 0)*9 + Math.max(carb-.499999, 0)*4 + Math.max(p-.4999999, 0)*4;
			
			
			
			
			if(c >= min && c <= max)
			{
				System.out.println("yes");
			}
			else
			{
				System.out.println("no");
			}
			c = in.nextDouble();
			f = in.nextDouble();
			carb = in.nextDouble();
			p = in.nextDouble();
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
