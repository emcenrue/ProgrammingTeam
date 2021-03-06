package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 260
 * Division 2
 * Problem B
 * @author Edward McEnrue
 *
 */
public class CF260_Fedya_and_Maths {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		String input = in.next();
		int num = 0;
		if(input.length() < 2)
		{
			num = Integer.parseInt(input.substring(input.length()-1));
		}
		else
		{
			num = Integer.parseInt(input.substring(input.length()-2));
		}
		
		if(num%4 == 0)
		{
			System.out.println("4");
		}
		else
		{
			System.out.println("0");
		}
		
		
//		for(int i = 0; i < 500; i++)
//		{
//			long j = (long) (Math.pow(1, i) + Math.pow(2, i) + Math.pow(3, i) + Math.pow(4, i));
//			System.out.println(i);
//			System.out.println(j);
//			System.out.println(j%5);
//		}
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
