package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;


/**
 * Codeforces.com 
 * Round 260 
 * Division 2
 * Problem A
 * @author Edward McEnrue
 *
 */
public class CF260_Laptops {
	
	static class Laptop implements Comparable<Laptop> {
		int price;
		int qlty;
		
		Laptop(int p, int q)
		{
			this.price = p;
			this.qlty = q;
		}

		@Override
		public int compareTo(Laptop l) {
			// TODO Auto-generated method stub
			if (this.price < l.price)
				return -1;
			if (this.price > l.price)
				return 1;
			return 0;
		}
	}
	
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		
		Laptop[] laps = new Laptop[n];
		
		for(int i = 0; i < n; i++)
		{
			int p = in.nextInt();
			int q = in.nextInt();
			laps[i] = new Laptop(p,q);
		}
		
		
		//Sort the array on prices
		
		Arrays.sort(laps);
		
		
		//Take the lower priced laptop and see if it is higher quality than the next laptop
		//Works because it is sorted by low to high price.
		for(int i = 1; i < n; i++)
		{
			if(laps[i-1].qlty > laps[i].qlty)
			{
				System.out.println("Happy Alex");
				return;
			}
		}
		System.out.println("Poor Alex");

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
