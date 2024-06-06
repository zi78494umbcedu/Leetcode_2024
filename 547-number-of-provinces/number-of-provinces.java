class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces=0;
        int vertices = isConnected.length;
        boolean[] visited=new boolean[vertices];
        for(int node=0;node<vertices;node++){
            if(!visited[node]){
                provinces++;
                dfs(node, isConnected, visited, vertices);
            }
        }
        return provinces;
    }
    static void dfs(int node, int[][] isConnected, boolean[] visited, int vertices){
        visited[node]=true;
        for(int i=0;i<vertices;i++){
            if(!visited[i] && (isConnected[i][node]==1||isConnected[node][i]==1)){
                dfs(i, isConnected, visited, vertices);
            }
        }
    }
}