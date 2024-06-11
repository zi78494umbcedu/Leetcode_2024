import java.util.*;
public class Solution {
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        //dijkstra's fails for negative weights, going into infinite loop
        //bellman ford is applicable only on DG - directed graphs
        //convert undirected to directed for BF to work
        //sequentially relax the distances for n-1 times 
        //for, the worst case of linear traversal would take n-1 times to get distances for all the nodes
        //for checking if negative cycles exists, do nth iteration and if relaxation possible 
        //O(n^2)--> O(v*e)

        // Set modulo value

        // Using a large value instead of 1e8
        int[] distances = new int[n+1];
        Arrays.fill(distances, 100000000);
        // Initialize distances
        distances[src] = 0;
        // Relax edges for n-1 times
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                int node1 = edges.get(j).get(0);
                int node2 = edges.get(j).get(1);
                int weight = edges.get(j).get(2);
                if(distances[node1] != 1000000000 && weight + distances[node1] < distances[node2]){
                    distances[node2] = (weight + distances[node1]);
                }
            }
        }
        // // Check for negative cycles
        // for(int j=0; j<m; j++){
        //     int node1 = edges.get(j).get(0);
        //     int node2 = edges.get(j).get(1);
        //     int weight = edges.get(j).get(2);
        //     if(distances[node1] != 1000000000 && weight + distances[node1] < distances[node2]){
        //         return new int[]{-1};
        //     }
        // }
         
        // Return distances
        return distances;


    }
}
