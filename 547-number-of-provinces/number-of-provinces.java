class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        int connt =0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                connt++;
                dfs(i, visit, isConnected);
            }
        }
        return connt;
    }

    public static void dfs(int node, boolean[] visit, int[][] isConnected){
        visit[node]=true;
        for(int i=0;i<isConnected.length;i++){
            if(!visit[i] && (isConnected[node][i]==1|| isConnected[i][node]==1)){
                dfs(i, visit, isConnected);
            }
        }
    }
}