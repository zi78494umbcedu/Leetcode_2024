//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    private static int timer;
    
    static void dfs(int node, int parent, boolean[] visited, int[] tin, int[] low, int[] mark,ArrayList<ArrayList<Integer>> adj ){
        visited[node]=true;
        tin[node]=low[node]=timer++;
        int child=0;
        for(int neighbour:adj.get(node)){
            if(neighbour==parent)continue;
            if(!visited[neighbour]){
                dfs(neighbour, node, visited, tin, low, mark, adj);
                low[node]=Math.min(low[node], low[neighbour]);
                if(low[neighbour]>=tin[node] && parent!=-1){
                    mark[node]=1;
                }
                child++;
            }else{
                low[node]=Math.min(low[node], tin[neighbour]);
            }
        }
        if(child>1 && parent==-1){
            mark[node]=1;
        }
    }
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        //Tarjan's algorithm of bridges
        //insertion time
        //minimum of insertion time of all the adjacents except parent and **visited nodes
        timer=1;
        boolean[] visited = new boolean[V];
        int[] tin = new int[V];
        int[] low= new int[V];
        int[] mark= new int[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i, -1, visited, tin, low, mark, adj);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(mark[i]==1){
                ans.add(i);
            }
        }
        if(ans.size()==0)ans.add(-1);
        return ans;
    }
}
