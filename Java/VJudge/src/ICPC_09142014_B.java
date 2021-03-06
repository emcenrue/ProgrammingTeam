import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;
import java.util.ArrayList;


/**
 * // -------------------------------------------------------------------------
/**
 *  ICPC practice
 *  09/14/2014
 *
 *  @author Daniel Gil
 *  @version Sep 14, 2014
 */
public class ICPC_09142014_B
{
    static char[][][] cube;
    static int        l;
    static int        r;
    static int        c;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args){//begin main //////////////////////
        
    	Scanner in = new Scanner();

        l = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        cube = new char[l][r][c];

        while (l + r + c != 0)
        {
            State start = null;

            for (int i = 0; i < l; i++)
            {
                for (int j = 0; j < r; j++)
                {
                    String temp = in.readNextLine();
                    if (temp.length() == 0) // handles grid separation
                    {
                        j--;
                        continue;
                    }

                    for (int k = 0; k < temp.length(); k++)
                    {
                        cube[i][j][k] = temp.charAt(k);
                        if (cube[i][j][k] == 'S')
                            start = new State(i, j, k);
                    }
                }
            }

            solve(start);

            l = in.nextInt();
            r = in.nextInt();
            c = in.nextInt();
            cube = new char[l][r][c];
        }
        // formats text to exclude last carriage return
        System.out.println(out.toString().substring(0, out.length() - 1));
    } //end main/////////////////////////////////////////////////////////////////////

    // bfs
    public static void solve(State start)
    {
        Set<State> visited = new HashSet<State>();
        Map<State, State> pred = new HashMap<State, State>();
        Map<State, Integer> dist = new HashMap<State, Integer>();
        Deque<State> bfs = new ArrayDeque<State>();

        bfs.offer(start);
        dist.put(start, 0);

        boolean reached = false;
        int min = Integer.MAX_VALUE;

        while (bfs.size() > 0)
        {
            State s = bfs.poll();
            int n = dist.get(s);
            visited.add(s);

            if (s.isfinal()) //write code that executes when target is found here
            {
                if (n < min) // tracks shortest path
                {
                    min = n;
                }
                reached = true;
                break;
            }

            for (State succ : s.successors())
            {
                if (visited.contains(succ))
                    continue;

                if (!pred.containsKey(succ))
                    pred.put(succ, s);

                if (!dist.containsKey(succ))
                {
                    dist.put(succ, n + 1);
                    bfs.offer(succ);
                }
            }
        }

        if (reached)
        {
            out.append("Escaped in "+min+" minute(s).");
            out.append("\n");
        }
        else
        {
            out.append("Trapped!");
            out.append("\n");
        }
    }


    public static class State
        implements Comparable<State>
    {
        int x;
        int y;
        int level;


        public State(int level, int x, int y)
        {
            this.level = level;
            this.x = x;
            this.y = y;
        }

        // successors are all adjacent possible moves
        // so in the cube, its going up or down a level, left right up and down
        // in the current level
        public List<State> successors()
        {
            List<State> list = new ArrayList<State>();

            if (this.level > 0 && cube[level - 1][x][y] != '#')
            {
                list.add(new State(level - 1, x, y));
            }
            if (this.level + 1 < l && cube[level + 1][x][y] != '#')
            {
                list.add(new State(level + 1, x, y));
            }
            if (this.x > 0 && cube[level][x - 1][y] != '#')
            {
                list.add(new State(level, x - 1, y));
            }
            if (this.x + 1 < r && cube[level][x + 1][y] != '#')
            {
                list.add(new State(level, x + 1, y));
            }
            if (this.y > 0 && cube[level][x][y - 1] != '#')
            {
                list.add(new State(level, x, y - 1));
            }
            if (this.y + 1 < c && cube[level][x][y + 1] != '#')
            {
                list.add(new State(level, x, y + 1));
            }

            return list;
        }

        // is the final state when it reaches E
        public boolean isfinal()
        {
            return cube[level][x][y] == 'E';
        }


        @Override
        public boolean equals(Object o)
        {
            State other = (State)o;
            return this.level == other.level && this.x == other.x
                && this.y == other.y;
        }


        @Override
        public int compareTo(State other)
        {
            return Integer.compare(this.level, other.level);
        }

        // guaranteed a unique hash code for each state
        // b/c max of 30 for each l, x, and y
        @Override
        public int hashCode()
        {
            return 900 * l + 30 * x + y;
        }
    }


    // -----------Pair class for comparisons--------------
    public static class Pair
        implements Comparable<Pair>
    {
        int x, y;


        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Pair o)
        {
            return Integer.compare(this.x, o.x);
        }


        @Override
        public int hashCode()
        {
            return x ^ y;
        }


        @Override
        public boolean equals(Object o)
        {
            Pair p = (Pair)o;
            return p.x == x && p.y == y;
        }
    }


    // -----------Scanner class for faster input----------
    /*
     * Provides similar API as java.util.Scanner but does not use regular
     * expression engine.
     */
    public static class Scanner
    {
        BufferedReader  br;
        StringTokenizer st;


        public Scanner(Reader in)
        {
            br = new BufferedReader(in);
        }


        public Scanner()
        {
            this(new InputStreamReader(System.in));
        }


        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }


        int nextInt()
        {
            return Integer.parseInt(next());
        }


        long nextLong()
        {
            return Long.parseLong(next());
        }


        double nextDouble()
        {
            return Double.parseDouble(next());
        }


        // Slightly different from java.util.Scanner.nextLine(),
        // which returns any remaining characters in current line,
        // if any.
        String readNextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    // --------------------------------------------------------
}
