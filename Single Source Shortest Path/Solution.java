import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

class Pair{
    int vertex;
    int distance;
    public Pair(int vertex, int distance){
        this.vertex=vertex;
        this.distance=distance;
    }
}    
public class Solution {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        //using breadth first search
        //adjacency matrix
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //undirected graph
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] distances = new int[n];
        Arrays.fill(distances, (int)(1e9));
        q.add(src);
        distances[src]=0;
        while(!q.isEmpty()){
            int tempNode =q.poll();
            for(int neighbour:adj.get(tempNode)){
                if(distances[neighbour]>distances[tempNode]+1){
                    distances[neighbour]=distances[tempNode]+1;
                    q.add(neighbour);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(distances[i]==(int)(1e9)){
                distances[i]=-1;
            }
        }
        return distances;
    }
}
