package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round TeamWarmUp
 * Division 2
 * Problem A
 * @author Edward McEnrue
 */
public class CFTeamWarmUp_Hash_Collisions {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		char[] sel = in.nextLine().toCharArray();
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		boolean found = false;
		
//		for(int i = 0; i < 500; i++)
//		{
//			String search = randString(n, sel);
//			System.out.println("rand test: " + search);
//		}
		
//		System.out.println("kgbhjkbb".hashCode());
//		System.out.println("dfijkdah".hashCode());
		
		while(!found)
		{
			String search = randString(n, sel);
			if(hm.get(search.hashCode()) != null && !search.equals(hm.get(search.hashCode())))
			{
				System.out.print(search + " " + hm.get(search.hashCode()));
				found = true;
			}
			else
			{
				hm.put(search.hashCode(), search);
			}
		}
		
		
	}
	
	private static String randString(int size, char[] letters)
	{
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++)
		{
			int ranInt = rand.nextInt(letters.length);
			sb.append(letters[ranInt]);
		}
		return sb.toString();
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
