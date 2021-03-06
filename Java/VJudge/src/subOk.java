import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subOk {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int x = 0x80000000;
		int y = 0x80000000;
		System.out.println("x : "+ x + " y :" + y);
		
		int opp = x + (~y + 1);
		System.out.println("(~y + 1) : "+ (~y + 1));
		System.out.println("x + (~y + 1) : " + opp);
		
		int chkSign = x ^ y;
		System.out.println("x ^ y : " +chkSign);
		
		int oppSign = opp ^x;
		System.out.println("opp ^x : " + oppSign);
		
		
		//return !((chkSign & oppSign) >> 31);
		System.out.println("chkSign & oppSign : "+(chkSign & oppSign));
		System.out.println("(chkSign & oppSign) >> 31  : " + ((chkSign & oppSign) >> 31));
		
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
