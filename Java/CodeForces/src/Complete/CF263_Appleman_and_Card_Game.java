package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 263
 * Division 2
 * Problem B
 * @author Edward McEnrue
 */
public class CF263_Appleman_and_Card_Game {

	
	
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		String hand = in.nextLine();
		
		HashMap<Character, Integer> cnt = new HashMap<Character,Integer>(); 
		
		for(int i = 0; i < hand.length(); i++)
		{
			if(cnt.get(hand.charAt(i)) == null)
			{
				cnt.put(hand.charAt(i), 1);
			}
			else
			{
				int freq = cnt.get(hand.charAt(i));
				cnt.put(hand.charAt(i), freq+1);
			}
		}
		
		int[] freqArr = new int[26];
		int z = 0;
		for(char alphabet = 'A'; alphabet <= 'Z';alphabet++) 
		{
//			System.out.println(alphabet);
//			System.out.println(z);
			if(cnt.get(alphabet) != null)
			{
				freqArr[z] = cnt.get(alphabet);
			}
		    
		    z++;
		}
		
//		for(int i = 0; i < 26; i++)
//		{
//			System.out.println(freqArr[i]);
//		}
		
		Arrays.sort(freqArr);
		
		long coin = 0;
		int index = 0;
		for(int i = 25; i >= 0; i--)
		{
			
			if(k > freqArr[i])
			{
				//index+=freqArr[i];
				coin += (long)freqArr[i]*(long)freqArr[i];
				k -= freqArr[i];
			}
			else if(k > 0)
			{
				coin += (long)k*(long)k; //might be a problem here where 
				k -= k;
				break;
			}
		}
		
		System.out.println(coin);
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
