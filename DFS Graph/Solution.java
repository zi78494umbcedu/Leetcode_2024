import java.util.ArrayList;
import java.util.List;

public class Solution {

    static void dfs(int node, boolean[] visited, List<Integer> component, List<List<Integer>> adj){
        visited[node]=true;
        component.add(node);
        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, visited, component, adj); 
            }

        }
    }
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            List<Integer> temp = new ArrayList<>();
            adj.add(temp);
        }
        for(int i=0;i<e;i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        boolean[] visited =new boolean[v];
        ArrayList<ArrayList<Integer>> traversals = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(!visited[i]){
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, visited, component, adj);
                traversals.add(component);
            }
            
        }
        return traversals;
    }

}
