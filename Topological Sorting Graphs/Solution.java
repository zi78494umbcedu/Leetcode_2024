import java.util.*;
import java.io.*;
public class Solution {

    /** 
    Depth first traversal
    */
    static void dfs(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack){
        visited[node]= true;
        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited, stack);
            }
        }
        stack.add(node);
    }
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        //use stack for LIFO for left, right nodes relation sorting
        //adjacency matrix
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        //visited array
        boolean[] visited = new boolean[v];
        //for our algo of sorting 
        Stack<Integer> stack = new Stack<Integer>();
        //components leverage
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(i, adj, visited, stack);
            }
        }
        //result
        List<Integer> topoSort = new ArrayList<>();
        while(!stack.isEmpty()){
            topoSort.add(stack.pop());
        }
        return topoSort;
    }

}
