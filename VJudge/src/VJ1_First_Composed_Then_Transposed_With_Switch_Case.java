import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Vjudge.net
 * Round 1
 * Division 2
 * Problem A
 * @author Edward McEnrue
 */
public class VJ1_First_Composed_Then_Transposed_With_Switch_Case {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();


		String s = in.nextLine();
		int tran = in.nextInt();
		
		while(!s.equals("***"))
		{
			String[] notes = s.split("\\s+");
			
			int pos = 0;
			for(String note : notes)
			{
				if(note.equals("Ab"))
				{
					pos = 11;
				}
				else if(note.equals("A"))
				{
					pos = 0;
				}
				else if(note.equals("A#"))
				{
					pos = 1;
				}
				else if(note.equals("Bb")) //A A# B C C# D D# E F F# G G#
				{
					pos = 1;
				}
				else if(note.equals("B")) //A A# B C C# D D# E F F# G G#
				{
					pos = 2;
				}
				else if(note.equals("B#")) //A A# B C C# D D# E F F# G G#
				{
					pos = 3;
				}
				else if(note.equals("Cb")) //A A# B C C# D D# E F F# G G#
				{
					pos = 2;
				}
				else if(note.equals("C")) //A A# B C C# D D# E F F# G G#
				{
					pos = 3;
				}
				else if(note.equals("C#")) //A A# B C C# D D# E F F# G G#
				{
					pos = 4;
				}
				else if(note.equals("Db")) //A A# B C C# D D# E F F# G G#
				{
					pos = 4;
				}
				else if(note.equals("D")) //A A# B C C# D D# E F F# G G#
				{
					pos = 5;
				}
				else if(note.equals("D#")) //A A# B C C# D D# E F F# G G#
				{
					pos = 6;
				}
				else if(note.equals("Eb")) //A A# B C C# D D# E F F# G G#
				{
					pos = 6;
				}
				else if(note.equals("E")) //A A# B C C# D D# E F F# G G#
				{
					pos = 7;
				}
				else if(note.equals("E#")) //A A# B C C# D D# E F F# G G#
				{
					pos = 8;
				}
				else if(note.equals("Fb")) //A A# B C C# D D# E F F# G G#
				{
					pos = 7;
				}
				else if(note.equals("F")) //A A# B C C# D D# E F F# G G#
				{
					pos = 8;
				}
				else if(note.equals("F#")) //A A# B C C# D D# E F F# G G#
				{
					pos = 9;
				}
				else if(note.equals("Gb")) //A A# B C C# D D# E F F# G G#
				{
					pos = 9;
				}
				else if(note.equals("G")) //A A# B C C# D D# E F F# G G#
				{
					pos = 10;
				}
				else if(note.equals("G#")) //A A# B C C# D D# E F F# G G#
				{
					pos = 11;
				}
				
				pos += tran;
				
				pos = pos % 12;
				
				if(pos < 0)
				{
					pos = 12+pos;
				}
				
				pos = Math.abs(pos);
				
				
				if(pos == 0)
				{
					System.out.print("A ");
				}
				else if(pos == 1)
				{
					System.out.print("A# ");
				}
				else if(pos == 2)
				{
					System.out.print("B ");
				}
				else if(pos == 3)
				{
					System.out.print("C ");
				}
				else if(pos == 4)
				{
					System.out.print("C# ");
				}
				else if(pos == 5)
				{
					System.out.print("D ");
				}
				else if(pos == 6)
				{
					System.out.print("D# ");
				}
				else if(pos == 7)
				{
					System.out.print("E ");
				}
				else if(pos == 8)
				{
					System.out.print("F ");
				}
				else if(pos == 9)
				{
					System.out.print("F# ");
				}
				else if(pos == 10)
				{
					System.out.print("G ");
				}
				else if(pos == 11)
				{
					System.out.print("G# ");
				}
				
				
			}
			
			System.out.println("");
			
			s = in.nextLine();
			if(!s.equals("***"))
			{
				tran = in.nextInt();
			}
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
