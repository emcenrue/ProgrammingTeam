import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round # 
 * Division 2
 * Problem D
 * @author Edward McEnrue
 */
public class Round_Robin {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		while(true)
		{
			int n = in.nextInt(); //number of players
			if(n == 0)
			{
				break;
			}
			
			int t = in.nextInt(); //number of turns per round
			
			//output the number of players left, and their score
			
			ArrayList<Integer> pl = new ArrayList<Integer>();
			for(int i = 0; i < n; i++)
			{
				pl.add(0);
			}
			
			boolean go = true;
			if(pl.size() == 0)
			{
				go = false;
			}
			if(go)
			{
				int first = pl.get(0);
				for(int i = 1; i < pl.size(); i++)
				{
					if(pl.get(i) != first)
					{
						go = false;
					}
				}
			}
			
			while(go)
			{
				int offset = 0;
				for(int j = 0; j < t; j++)
				{
					pl.set((j+offset)%pl.size(), pl.get((j+offset)%pl.size()));// pl.size might be 0 maybe? probably not
					if(j == t-1)
					{
						offset = (j+offset)%pl.size();
						pl.remove((j+offset)%pl.size());
						if(offset == pl.size())
							offset = 0;
					}
				}
				
				
				//Checks if the game is over
				if(pl.size() == 0)
				{
					go = false;
				}
				if(go)
				{
					int first = pl.get(0);
					for(int i = 1; i < pl.size(); i++)
					{
						if(pl.get(i) != first)
						{
							go = false;
						}
					}
				}
			}
			
			if(pl.size() != 0)
				System.out.println(pl.size() + " " + pl.get(0));
			else
				System.out.println(pl.size() + " " + 0);
				
			
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
