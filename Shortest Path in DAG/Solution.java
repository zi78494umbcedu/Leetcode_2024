import java.util.*;


class Pair{
    int vertex;
    int weight;
    public Pair(int vertex, int weight){
        this.vertex=vertex;
        this.weight=weight;
    }
}
public class Solution {

    static void dfs(int node, List<List<Pair>> adj, boolean[] visited, Stack<Integer> stack){
        visited[node]=true;
        for(Pair neighbour:adj.get(node)){
            if(!visited[neighbour.vertex]){
                dfs(neighbour.vertex, adj, visited, stack);
            }
        }
        stack.add(node);
    }
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        // Adjacency Graph with weights
        // Topo sort
        // minimum of distances traversing the topoSort
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
        //topo sort using depth first search using a stack+visited
        Stack<Integer> stack= new Stack<Integer>();
        boolean[] visited= new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, adj, visited, stack);
            }
        }
        // List<Integer> topoSort= new ArrayList<>();
        // while(!stack.isEmpty()){
        //     topoSort.add(stack.pop());
        // }
        int[] distances =new int[n];
        Arrays.fill(distances, (int)(1e9));
        distances[0]=0;
        while(!stack.isEmpty()){
            int temp= stack.pop();
            for(Pair neighbour:adj.get(temp)){
                //System.out.println("temp: "+temp+", vertex: "+neighbour.vertex+", weight: "+neighbour.weight+", temp_distance: "+distances[temp]);
                if(distances[neighbour.vertex]>(distances[temp]+neighbour.weight)){
                    distances[neighbour.vertex]=distances[temp]+neighbour.weight;
                }
            }
        }
        for(int i=0;i<distances.length;i++){
            if(distances[i]==(int)(1e9)){
                distances[i]=-1;
            }
        }
        return distances;

    }
}
