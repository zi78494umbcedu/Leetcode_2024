class Solution {
    public int findCircleNum(int[][] isConnected) {
        //convert matrix into adjacency list
         int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        //basic DFS, once not found increase counter
        boolean[] visited = new boolean[n+1];
        int provinces =0;
        //recursion for DFS
        for(int i=0;i<n;i++){
            if(!visited[i]){
                provinces++;
                dfs(i, adj, visited);
            }
        }
        return provinces;
    }
    static void dfs(int i, List<List<Integer>> adj, boolean[] visited){
        visited[i]=true;
        for(int neighbour:adj.get(i)){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited);
            }
        }
    }
}