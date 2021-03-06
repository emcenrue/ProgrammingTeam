package Complete;
import java.util.*;

public class Brendan_DP {
	static HashMap<Tup, Integer> memo;
	static int[][] rooms;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int N = in.nextInt();
			int k = in.nextInt();
			
			if (N == 0 && k == 0) {
				return;
			}
			
			rooms = new int[N][2];
			for (int i = 0; i < N; i++) {
				rooms[i][0] = in.nextInt();
				rooms[i][1] = in.nextInt();
			}
			
			memo = new HashMap<Tup, Integer>();
			
			System.out.println(recurse(N-1, k, -1));
		}
	}
	
	public static int recurse(int N, int k, int p) {
		if (N < 0 && k == 0) {
			return 0;
		}
		if ((N < 0 && k > 0) || k > N+1) {
			return -1111111111;
		}
		
		Tup curr = new Tup(N, k, p);
		if (memo.containsKey(curr)) {
			return memo.get(curr);
		}
		
		int noBlock = rooms[N][0]+rooms[N][1]+recurse(N-1, k, -1);
		int blockLeft = -11111111;
		int blockRight = -11111111;
		if (k > 0) {
			if (p != 1) {
				blockLeft = rooms[N][1]+recurse(N-1, k-1, 0);
			}
			if (p != 0) {
				blockRight = rooms[N][0]+recurse(N-1, k-1, 1);
			}
		}
		
		int max = Math.max(noBlock, Math.max(blockLeft, blockRight));
		memo.put(curr, max);
		
		return max;
	}
	
	public static class Tup {
		int N, k, p;
		
		public Tup(int a, int c, int e) {
			N = a;
			k = c;
			p = e;
		}
		
		public int hashCode() {
			return N*100000 + k*1000 + p;
		}
		
		public boolean equals(Object o) {
			Tup other = (Tup)o;
			return (N == other.N && k == other.k && p == other.p);
		}
	}
}
