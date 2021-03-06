import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round TeamWarmUp
 * Division 2
 * Problem B
 * @author Edward McEnrue
 *
 */
public class CFTeamWarmUp_Canonical_Cycle_Representation {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = in.nextInt();
		}
		
		ArrayList<ArrayList<Integer>> arrHolder = new ArrayList<ArrayList<Integer>>();
		
		int setVar = arr[0];
		
		for(int i = 0; i < n; i++)
		{
			setVar = arr[i]; //1|4|
			if(setVar != -1)
			{
				int hopVar = arr[i];//1|4|
				//System.out.println(hopVar);
				ArrayList<Integer> setArr = new ArrayList<Integer>();
				arr[i] = -1; //-1 4 6 5 2 3 |-1 -1 6 5 2 3|
				while(hopVar != -1)
				{
					//System.out.println(hopVar);
					
//					for(int k = 0; k < arr.length; k++)
//					{
//						System.out.print(arr[k] + " ");
//					}
//					System.out.println("");
					int curr = hopVar; //4|5
					setArr.add(hopVar); // {1, |{4, 5
					hopVar = arr[hopVar-1];//-1|5|2
					if(hopVar != -1)
					{
						arr[curr-1] = -1; //-1 -1 6 -1 2 3 || -1 -1 6 -1 -1 3
					}
					
					if(hopVar == -1 && setArr.size() != 1) //might not need the check for -1 here
					{
						arrHolder.add(setArr);
					}
					
				}
			}
		}
		//System.out.println(arrHolder.size());
		
		for(int i = 0; i < arrHolder.size(); i++)
		{
			Collections.sort(arrHolder.get(i));
		}
		
		if(arrHolder.size() == 0)
		{
			System.out.println("-");
		}
		else
		{
			for(int i = arrHolder.size()-1; i >= 0; i--)
			{
				for(int j = 0; j < arrHolder.get(i).size(); j++)
				{
					System.out.print(arrHolder.get(i).get(j) + " ");
				}
			}
		}
		
		
	}
	
//	private static void set(int start, int prev, ArrayList<Integer> num)
//	{
//		System.out.print(num.get(start));
//		if(start> prev)
//		{
//			num.remove(start);
//			set(num.get(start-1), start, num);
//			
//		}
//		
//	}

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
