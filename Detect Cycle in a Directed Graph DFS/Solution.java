import java.util.*;

public class Solution 
{
    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
        //create adjacency matrix
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int[] visited = new int[v];
        for(int i=0;i<v;i++){
            if(visited[i]==0){
                if(dfs(adj, visited, i)){
                    return true;
                }
            }
        }
        return false;
	}

    static boolean dfs(List<List<Integer>> adj, int[] visited, int node){
        visited[node]=2;
        for(int neighbour:adj.get(node)){
            if(visited[neighbour]==0){
                if(dfs(adj, visited,neighbour)){
                    return true;
                }
            }else if(visited[neighbour]==2){
                return true;
            }
        }
        visited[node]=1;
        return false;
    }
}
