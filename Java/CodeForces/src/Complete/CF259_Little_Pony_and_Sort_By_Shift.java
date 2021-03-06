package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;




public class CF259_Little_Pony_and_Sort_By_Shift {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		
		int[] seq = new int[n];
		
		seq[0] = in.nextInt();
		int dipCnt = 0;
		
		int shiftCnt = 0;
		
		for(int i = 1; i < n; i++)
		{
			seq[i] = in.nextInt();
			int prev = seq[i-1];
			int cur = seq[i];
			
			
			if(cur < prev)
			{
				if(dipCnt == 0)
				{
					shiftCnt = n-i;
				}
				dipCnt++;
			}
			
			if(dipCnt > 1)
			{
				break;
			}
		}
		
		if(seq[0] < seq[n-1])
		{
			dipCnt++;
		}
		
		if(dipCnt > 1)
		{
			System.out.println("-1");
		}
		else
		{
			System.out.println(shiftCnt);
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
