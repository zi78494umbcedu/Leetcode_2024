//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //visited matrix of size
        boolean[][] visited = new boolean[n][m];
        int islands=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    islands++;
                    bfs(visited, i, j, grid, n, m);
                }
            }
        }
        return islands;
    }
    static void bfs(boolean[][] visited, int row, int col, char[][] grid, int n, int m){
        visited[row][col]=true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int r = temp.row;
            int c =temp.col;
            int[] rows = {-1, -1, -1, 0, +1, +1, +1, 0};
            int[] cols = {-1, 0, +1, +1, +1, 0, -1, -1};
            for(int i=0;i<8;i++){
                int ru = r+rows[i];
                int cu = c+cols[i];
                if(ru>=0 && ru<n && cu>=0 && cu<m && !visited[ru][cu] && grid[ru][cu]=='1'){
                    visited[ru][cu]=true;
                    q.add(new Pair(ru, cu));
                }
            }
            //top left      (row-1, col-1)
            //top           (row-1, col)
            //top right     (row-1, col+1)
            //right         (row, col+1)
            //bottom right  (row+1, col+1)
            //bottom        (row+1, col)
            //bottom left   (row+1, col-1)
            //left          (row, col-1)
        }
        
    }
}
