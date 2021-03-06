
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Codeforces.com 
 * Round 263
 * Division 2
 * Problem C
 * @author Edward McEnrue
 */
public class CF263_Appleman_and_Toastman {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		
		int[] arr = new int[n];
		
		long total = 0;
		
		for(int i = 0; i < n; i++)
		{
			arr[i] = in.nextInt();
			total += (long) arr[i]; //9
		}
		
		
		Arrays.sort(arr);
		
		long leftOver = total;
		
		for(int i = 0; i < n-1; i++)
		{
			total += leftOver; //1*0 3*1 5*2 -> 22
			// 1 3 5 --> 9
			// 3 5 --> 8
			
			leftOver -= arr[i];
			
			
		}
		
		System.out.println(total);
		
		

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
