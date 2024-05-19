//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] colorArray = new int[n];
        //m - number of colors
        //n - numbers of nodes
        return recursiveColoring(0, graph, colorArray, n, m);
    }
    
    static boolean recursiveColoring(int ind, boolean[][] graph, int[] colorArray, int n, int m){
        if(ind==n){
            return true;
        }
        for(int i=1;i<=m;i++){
            if(safeToColorNode(ind, graph, colorArray, i, n)){
                colorArray[ind]=i;
                if(recursiveColoring(ind+1, graph, colorArray, n, m))return true;
                colorArray[ind]=0;
            }
        }
        return false;
    }
    
    static boolean safeToColorNode(int node, boolean[][] graph, int[] colorArray, int color, int n){
        for(int i=0;i<n;i++){
            if(graph[node][i] && colorArray[i]==color)return false;
        }
        return true;
    }
}
