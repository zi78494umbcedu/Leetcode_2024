class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> queenCombinations = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        recurCombinations(n, board, queenCombinations, 0);
        return queenCombinations;
    }

    //checking for 
    //1.left same row
    //2.left top diagonal
    //3.left bottom diagonal

    static boolean safeQueenPlace(int row, int col, int n, char[][] board){
        int tempRow=row;
        int tempCol = col;
        //check 1
        while(tempCol>=0){
            if(board[tempRow][tempCol]=='Q')return false;
            tempCol--;
        }
        tempRow = row;
        tempCol = col;
        //check 2
        while(tempCol>=0 && tempRow>=0){
            if(board[tempRow][tempCol]=='Q')return false;
            tempCol--;
            tempRow--;
        }
        //check 3
        tempRow = row;
        tempCol = col;
        while(tempCol>=0 && tempRow<n){
            if(board[tempRow][tempCol]=='Q')return false;
            tempCol--;
            tempRow++;
        }
        return true;
    }
    static List<String> addCharBoard(char[][] board){
        List<String> boardStringList = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder current = new StringBuilder();
            for(int j=0;j<board.length;j++){
                current.append(board[i][j]);
            }
            boardStringList.add(current.toString());
        }

        return boardStringList;
    }
    static void recurCombinations(int n, char[][] board, List<List<String>> combinations, int col){
        if(col==n){
            combinations.add(addCharBoard(board));
            return;
        }
        for(int row=0;row<n;row++){
            if(safeQueenPlace(row, col, n, board)){
                board[row][col] = 'Q';
                recurCombinations(n, board, combinations, col+1);
                board[row][col] = '.';
            }
        }
    }
}