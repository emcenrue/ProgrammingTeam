import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 261
 * Division 2
 * Problem B
 * @author Edward McEnrue
 *
 */
public class CF261_Pashmak_and_Flowers {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		
		Integer[] b = new Integer[n];
		
		for(int i = 0; i < b.length; i++)
		{
			b[i] = in.nextInt();
		}
		
		Arrays.sort(b);
		
		int sm = b[0];
		int cntS = 0;
		int big = b[n-1];
		int cntB = 0;
		
		long mul;
		
		if(big == sm)
		{
			long ans = (long) n * (n - 1) / 2;
			System.out.println("0 "+ans);
			return;
		}
		else
		{
			for(int i = 0; i < n; i++)
			{
				if(b[i] == sm)
				{
					cntS++;
				}
				if(b[i] == big)
				{
					cntB++;
				}
			}
			mul = (long)cntS*cntB;
			System.out.println(big-sm+ " " +mul);
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
