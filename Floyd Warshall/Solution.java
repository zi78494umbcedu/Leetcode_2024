import java.util.*;

public class Solution {
  static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
    // multi-source shortest path
    // thus a matrix
    // dynamic programming approach of using pre-computed information
    // it is a non-untuitive brute force method O(n^3) 
    // floyd warshall bases on distance of node itself being zero
    // if distance of node itself is negative then exist negative cycles
    int INF = 1000000000;
    int[][] distance = new int[n + 1][n + 1];
        
        // Initialize the distance matrix
        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }
        
        // Populate the distance matrix with the given edges
        for (int i = 0; i < m; i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int w = edges.get(i).get(2);
            distance[u][v] = w;
        }
        
        // Apply the Floyd-Warshall algorithm
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (distance[i][k] != INF && distance[k][j] != INF) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
        
        // Check for negative cycles
        for (int i = 1; i <= n; i++) {
            if (distance[i][i] < 0) {
                return -1;
            }
        }
        
        return distance[src][dest] == INF ? INF : distance[src][dest];
    
      
  }

}
