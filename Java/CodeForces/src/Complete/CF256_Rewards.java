package Complete;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CF256_Rewards {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		int cups = in.nextInt() + in.nextInt() + in.nextInt();
		int medals = in.nextInt() + in.nextInt() + in.nextInt();
		int shelves = in.nextInt();

		//System.out.println(""+Math.ceil(medals/10.0));
		//System.out.println(""+Math.ceil(cups/5.0));
		

		shelves = shelves - ((int) (Math.ceil(medals/10.0) + Math.ceil(cups/5.0)));
		
		if(shelves >= 0)
		{
			System.out.println("YES");
			
		}
		else
		{
			System.out.println("NO");
		}
			
		
		//no cups n medals
		//no more than 5 cups or 10 medals
		
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
}
