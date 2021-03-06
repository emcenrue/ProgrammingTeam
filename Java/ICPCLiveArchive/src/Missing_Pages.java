import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Utilities.IO_Template.MyScanner;


/**
 * PC^2
 * Round 6
 * Division 2
 * Problem F
 * @author Edward McEnrue
 */
public class Missing_Pages {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		while(true)
		{
			int n = in.nextInt();
			if(n == 0)
				break;
			int p = in.nextInt();
			
			if(p%2 == 0 && p <= n/2)
			{
				System.out.println(p-1+" "+(n-p+1)+" "+(n-p+2));
			}
			else if(p%2 == 1 && p <= n/2)
			{
				System.out.println(p+1+" "+(n-p)+" "+(n-p+1));
			}
			else if(p%2 == 0 && p > n/2)
			{
				System.out.println((n-p+1)+" "+(n-p+2)+" "+(p-1));
			}
			else
			{
				System.out.println((n-p)+" "+(n-p+1)+" "+(p+1));
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
