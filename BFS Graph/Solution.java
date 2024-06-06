import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        List<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int vertex = q.poll();
            bfs.add(vertex);
            for(int neighbour:adj.get(vertex)){
                if(!visited[neighbour]){
                    q.add(neighbour);
                    visited[neighbour]=true;
                }
            }
        }
        return bfs;
    }
}

