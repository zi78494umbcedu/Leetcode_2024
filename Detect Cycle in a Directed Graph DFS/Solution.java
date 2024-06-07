public class Solution 
{
    static boolean dfs(int node, int[][] edges, int[] visited, int[] pathVisited){
        visited[node]=1;
        pathVisited[node]=1;
        for(int adj:edges[node]){
            if(visited[adj]==0){
                if(dfs(adj, edges, visited, pathVisited)==true){
                    return true;
                }
            }else if(pathVisited[adj]==1){
                return true;
            }
        }
        pathVisited[node]=0;
        return false;
    }
    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
        int[] visited = new int[v];
        int[] pathVisited = new int[v];
        for(int i=0;i<v;i++){
            if(visited[i]==0){
                if(dfs(i, edges, visited, pathVisited)==true){
                    return true;
                }
            }
        }
        return false;
	}
}
