class Solution {

    public static void dfs(int i, int j, boolean[] visited, char[][] grid, int m , int n){
        visited[i*n+j]=true;
        /**
        right - 0, +1
        +1, +1
        down +1, 0
        +1, -1
        left 0, -1
        -1, -1
        up -1, 0
        -1, +1
         */
        int[] dx= {0, +1, 0, -1};
        int[] dy= { +1, 0, -1,  0};
        for(int p=0;p<4;p++){
            int du = i+dx[p];
            int dv = j+dy[p];
            if(du<m && du>=0 && dv<n && dv>=0 && grid[du][dv]=='1' && !visited[du*n+dv]){
                dfs(du, dv, visited,grid,  m, n);
            }
        }

    }

    public int numIslands(char[][] grid) {
        /**
        traverse through the matrix to find the first 1
        do traversal marking visited and counting numIslands
        basic dfs that can travel in all 8 directions 
        visited array of size m*n
         */
        int m = grid.length;
        int n = grid[0].length;
        boolean[] visited = new boolean[m*n+1];
        int numIslands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i*n+j]){
                    numIslands++;
                    dfs(i, j, visited, grid, m, n);
                }
            }
        }
        for(int i=0;i<m*n;i++){
            System.out.println(visited[i]);
        }
        return numIslands;

    }
}
/// 4,5
/// 0, 1, 2, 3, 4
/// 5, 6, 7, 8, 9

/// 0,0, 0,1 0,2 0,3 0,4
/// 1,0, 1,1, 1,2 1,3 1,4

