package Complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import Utilities.IO_Template.MyScanner;

public class CFFF_DZYLovesHash {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int p = in.nextInt();
		int n = in.nextInt();

		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();

		boolean conflict = true;

		for (int i = 0; i < n; i++) {
			int x = in.nextInt();

			if (table.get(x % p) == null) {
				table.put(x % p, 1);
			} else {
				System.out.println("" + (i+1));
				conflict = false;
				break;
			}

		}

		if (conflict) {
			System.out.println("-1");
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
}
