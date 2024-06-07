class Solution {
    public int numEnclaves(int[][] grid) {
        //boundary marking and bfs
        //finding the remaining enclaves of land inside 
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||i==m-1 || j==0||j==n-1){
                    if(grid[i][j]==1 && visited[i][j]==0){
                        q.add(new int[]{i, j});
                        visited[i][j]=1;
                    }
                }
            }
        }
        //bfs for the boundary 1's
        //
        int[] rows  = {+1, 0, -1, 0};
        int[] cols = {0, +1, 0, -1};
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col =q.poll()[1];
            for(int i=0;i<4;i++){
                int ru=row+rows[i];
                int cu = col+cols[i];
                if(ru>=0 && ru<m && cu>=0 && cu<n && grid[ru][cu]==1 && visited[ru][cu]==0){
                    visited[ru][cu]=1;
                    q.add(new int[]{ru, cu});
                }
            }
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;

    }
}