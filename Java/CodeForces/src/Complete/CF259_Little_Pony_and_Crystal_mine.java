package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CF259_Little_Pony_and_Crystal_mine {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		
		char[][] matrix = new char[n][n];
		
		int dPos = (int)Math.floor(n/2)-1;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(i < Math.floor(n/2))
				{
					if(j >= Math.floor(n/2)-i && j <= Math.floor(n/2)+i )
					{
						matrix[i][j] = 'D';
					}
					else
					{
						matrix[i][j] = '*';
					}
					
				}
				else if(i == Math.floor(n/2))
				{
					matrix[i][j] = 'D';
				}
				else
				{
					if(j >= Math.floor(n/2)-dPos && j <= Math.floor(n/2)+dPos)
					{
						matrix[i][j] = 'D';
					}
					else
					{
						matrix[i][j] = '*';
					}
				}
			}
			if(i > Math.floor(n/2))
			{
				dPos--;
			}
		}
		
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print(matrix[i][j]);
			}
			System.out.println("");
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
