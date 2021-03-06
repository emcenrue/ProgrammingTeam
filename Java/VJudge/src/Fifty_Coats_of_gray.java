import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Fifty_Coats_of_gray {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		int n = in.nextInt();
		int width = in.nextInt();
		int length = in.nextInt();
		int height = in.nextInt();
		int area = in.nextInt(); //cans
		int m = in.nextInt();
		
		while(true)
		{
			if(n == 0 && width == 0 && length == 0 && height == 0 && area == 0 && m == 0){
				break;
			}
			int areaToS = 0;
			for(int i = 0; i < m; i++){
				areaToS += in.nextInt() *in.nextInt();
			}
			int totArea = 0;
			totArea += length*width;
			totArea += width*height*2;
			totArea += length*height*2;
			totArea -=areaToS;
			totArea *=n;
			
//			int iAns = totArea/area;
			
			double ans = (double)totArea/area;
//			if(iAns+.000001 > ans)
//			{
//				System.out.println(iAns);
//			}else{

				System.out.println((int)Math.ceil(ans));
//			}
			
			
			n = in.nextInt();
			width = in.nextInt();
			length = in.nextInt();
			height = in.nextInt();
			area = in.nextInt();
			m = in.nextInt();
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
