import java.util.List;
public class Solution {
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            boolean[] visited   = new boolean[V];
            for(int i=0;i<V;i++){
                if(!visited[i]){
                    if(dfs(i, -1, visited, adj)){
                        return true;
                    }
                }
            }
            return false;
        }

        static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj){
            visited[node]=true;
            for(int neighbour:adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    if(dfs(neighbour, node, visited, adj)){
                        return true;
                    }
                }
                else if(parent!=neighbour){
                    return true;
                }
            }
            return false;
        }
    };
}
