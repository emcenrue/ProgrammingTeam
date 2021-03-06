
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 258
 * Division 2
 * Problem B
 * @author Edward McEnrue, [Potential Friendly coder helper1], [Potential Friendly coder helper2]
 *
 */
public class CF258_PredictOutcomeOfGame {

	public static void main(String[] args) {
        MyScanner in = new MyScanner();

        int trials = in.nextInt();
        
        for(int z = 0; z < trials; z++)
        {
        	int n = in.nextInt();
        	int k = in.nextInt();
        	int d1 = in.nextInt();
        	int d2 = in.nextInt();
        	
        	if(solve(n,k,d1,d2))
        	{
        		System.out.println("yes");
        	}
        	else
        	{
        		System.out.println("no");
        	}
        }
    }
	
	
	public static boolean solve(int n, int k, int d1, int d2) 
	{
		if(n % 3 == 0)
		{
			
	    	
			int minD = Math.min(d1, d2); 
    		int maxD = Math.max(d1, d2);
    		
    		if(minD != maxD)
    		{
    			maxD -= minD;
        		minD = 0;
    		}
    		
			
	    	for(int gL = n-k; gL > 0; gL--)
	    	{
	    		//System.out.println("GL: "+gL+" large D: "+maxD+" small D: "+minD);
	    		//subtract the lower d's from the higher d
	    		
	    		if(minD != 0) //empty from the lower d
	    		{
	    			minD--;
	    		}
	    		else if(maxD != 0) //empty from the higher d's to lower
	    		{
	    			minD++;
	    			maxD--;
	    		}
	    		else //empty from gL to higher d's
	    		{
	    			maxD++;
	    		}
	    		
	    	}
	    	if(minD == 0 && maxD == 0)
	    	{
	    		return true;
	    	}
		}
		return false;
	}
	
	
	//-----------MyScanner class for faster input----------
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
}
