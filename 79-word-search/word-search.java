class Solution {
    public boolean exist(char[][] board, String word) {
        int m =board.length;
        int n = board[0].length;
        int index=0;
        //searching for the 1st char
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(index)){
                    if(recursiveWordSearch(board, word, i, j, index,m, n))return true;
                }
            }
        }
        return false;
    }
    static boolean recursiveWordSearch(char[][] board, String word, int row, int col, int index, int m, int n){
        if(index==word.length())return true;
        if(row<0 ||col<0 ||row==m || col==n || board[row][col]!=word.charAt(index) || board[row][col]=='!')return false;
        //replacement of the visited matrix
        char c = board[row][col];
        board[row][col]='!';
        //DLRU +1, 0, 0, -1 || 0, -1,+1, 0
        //down direction
        boolean down = recursiveWordSearch(board, word, row+1, col, index+1,m, n);
        //left direction
        boolean left = recursiveWordSearch(board, word, row, col-1, index+1,m, n);
        //right direction
        boolean right = recursiveWordSearch(board, word, row, col+1, index+1,m, n);
        //up direction
        boolean up = recursiveWordSearch(board, word, row-1, col, index+1,m, n);
        //undo change if not found
        board[row][col]=c;
        return down || left || right || up;
    }
}