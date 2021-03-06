package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Mixed_Fractions {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		long n = in.nextLong();
		long d = in.nextLong();
		
		
		
		while (n + d != 0)
		{
			
			if(n % d == 0)
			{
				System.out.println(""+(n/d)+ " 0 / "+d);
			}
			else if(n < d)
			{
				System.out.println("0 "+n+" / "+d);
			}
			else
			{
				System.out.println((n/d)+" "+(n%d) + " / "+d);
			}
			n = in.nextLong();
			d = in.nextLong();
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
