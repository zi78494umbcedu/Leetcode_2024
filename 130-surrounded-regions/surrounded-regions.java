class Solution {

    static void dfs(int row, int col, char[][] board, int[][] visited, int[] rows, int[] cols, int m, int n){
        visited[row][col]=1;
        for(int i=0;i<4;i++){
            int ru = row+rows[i];
            int cu = col+cols[i];
            if(ru>=0 && ru<m && cu>=0 && cu<n && visited[ru][cu]==0 && board[ru][cu]=='O'){
                dfs(ru, cu, board, visited, rows, cols, m, n);
            }
        }
    }
    public void solve(char[][] board) {
        //finding boundary O's and marking the dfs O's in a new visited matrix
        //converting rest O's into X's and return
        int m=board.length;
        int n=board[0].length;
        int[][] visited=new int[m][n];
        //up row-1, col//right row, col+1//down row+1, col//left row, col-1
        int[] rows = {-1, 0, +1, 0};
        int[] cols = {0, +1, 0, -1};
        //1st row check
        for(int i=0;i<n;i++){
            if(visited[0][i]==0 && board[0][i]=='O'){
                dfs(0, i, board, visited, rows, cols, m, n);
            }
        }
        //last row check
        for(int i=0;i<n;i++){
            if(visited[m-1][i]==0 && board[m-1][i]=='O'){
                dfs(m-1, i, board, visited, rows, cols, m, n);
            }
        }
        //1st col check
        for(int i=0;i<m;i++){
            if(visited[i][0]==0 && board[i][0]=='O'){
                dfs(i, 0, board, visited, rows, cols, m, n);
            }
        }
        //last row check
        for(int i=0;i<m;i++){
            if(visited[i][n-1]==0 && board[i][n-1]=='O'){
                dfs(i, n-1, board, visited, rows, cols, m, n);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}