package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 3 
 * Division 2
 * Problem B
 * @author Edward McEnrue
 */
public class Main 
{
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int r = in.nextInt();
		int c = in.nextInt();
		while(r != 0 || c != 0)
		{
		int[][] map = new int[r][c];
		
		for(int i = 0; i < r; i++)
		{
			String row = in.nextLine();
			for(int j = 0; j < c; j++)
			{
				if(row.charAt(j) == '*')
				{
					map[i][j] = -1;
				}
				else
				{
					map[i][j] = 0;
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i < r; i++) //rows going down
		{
			for(int j = 0; j < c; j++) //columns going across
			{
				if(map[i][j] != -1)
				{
					if(i > 0 && map[i-1][j] == -1)
					{
						map[i][j]++;
					} 
					if(j > 0 && map[i][j-1] == -1)
					{
						map[i][j]++;
					}
					if(j > 0 && i > 0 && map[i-1][j-1] == -1)
					{
						map[i][j]++;
					}
					if(j > 0 && i < r-1 && map[i+1][j-1] == -1)
					{
						map[i][j]++;
					}
					if(j < c-1 && i > 0 && map[i-1][j+1] == -1)
					{
						map[i][j]++;
					}if(j < c-1 && map[i][j+1] == -1)
					{
						map[i][j]++;
					}
					if(j < c-1 && i < r-1 && map[i+1][j+1] == -1)
					{
						map[i][j]++;
					}
					if(i < r-1 && map[i+1][j] == -1)
					{
						map[i][j]= map[i][j]+1;
					}
				}
			}
		}
		
		
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				if(map[i][j] == -1)
				{
					
					System.out.print('*');
				}
				else
				{
					System.out.print(map[i][j]);
				}
			}
			System.out.println("");
		}
		
		r = in.nextInt();
		c = in.nextInt();
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
