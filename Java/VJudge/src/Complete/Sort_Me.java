package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * PC^2
 * Round 6
 * Division 2
 * Problem H
 * @author Edward McEnrue
 */
public class Sort_Me {

	static class Sort implements Comparator<String>
	{

		char[] order;
		
		public Sort(char[] alpha)
		{
			this.order = alpha;
		}
		
		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int n = in.nextInt();
		int year = 1;
		while(n!=0)
		{
			char[] alpha = in.next().toCharArray();
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for(int z = 0; z < alpha.length; z++)
			{
				map.put(alpha[z], z);
			}
			
			ArrayList<String> words = new ArrayList<String>();
			for(int i = 0; i < n; i++)
			{
				String s = in.nextLine();
				words.add(s);
			}
			
			Collections.sort(words, new StringComparator(map));
				
			
			System.out.println("year "+year);
			year++;
			
			for(int k = 0; k < words.size(); k++)
			{
				System.out.println(words.get(k));
			}
			
			n = in.nextInt();
		}
	}
	
	public static class StringComparator implements Comparator<String>
	{
		HashMap<Character, Integer> map;
		
		public StringComparator(HashMap<Character, Integer> ma)
		{
			this.map = ma;
		}

		@Override
		public int compare(String s1, String s2) {

			int maxLen = Math.min(s1.length(), s2.length());
			for(int i = 0; i < maxLen; i++)
			{
				if(map.get(s1.charAt(i)) < map.get(s2.charAt(i)))
					return -1;
				if(map.get(s1.charAt(i)) > map.get(s2.charAt(i)))
					return 1;
			}
			// negative if s1 is before s2
			// 0 if equal
			// positive if s1 is after s2
			return s1.length()-s2.length(); 
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
