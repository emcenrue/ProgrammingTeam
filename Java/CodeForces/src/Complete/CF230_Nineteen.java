package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 230
 * Division 2
 * Problem A
 * @author Edward McEnrue
 *
 */
public class CF230_Nineteen 
{
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		char[] s = in.next().toCharArray();
		
		int nCnt = 0; 
		int iCnt = 0; 
		int eCnt = 0; 
		int tCnt = 0; 
		for(int i = 0; i < s.length; i++)
		{
			if(s[i] == 'n')
			{
				nCnt++;
			}
			else if(s[i] == 'i')
			{
				iCnt++;
			}
			else if(s[i] == 'e')
			{
				eCnt++;
			}
			else if(s[i] == 't')
			{
				tCnt++;
			}
		}
		
		if(nCnt < 5)
		{
			nCnt = (int) Math.floor(nCnt/3); 
		}
		else
		{
			if(nCnt%2 == 0)
			{
				nCnt = ((int) Math.floor(nCnt/2))-1; //7/2.5 ninetee //27
			}
			else
			{
				nCnt = ((int) Math.floor(nCnt/2));
			}
		}
		eCnt = (int) Math.floor(eCnt/3); 
		
		System.out.println(Math.min(nCnt, Math.min(iCnt, Math.min(eCnt, tCnt))));
		
		
		

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
