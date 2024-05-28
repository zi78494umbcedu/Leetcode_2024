class Solution {
    public void setZeroes(int[][] matrix) {
        //better approach O(n^2)
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row =new boolean[m];
        boolean[] col =new boolean[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i] || col[j]){
                    matrix[i][j]=0;
                }
            }
        }

        // //Brute force O(n^3) marking '-1'
        // int m = matrix.length;
        // int n = matrix[0].length;
        // boolean needChange=false;
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(matrix[i][j]==0){
        //             markRow(i, matrix, n);
        //             markCol(j, matrix, m);
        //             needChange=true;
        //         }
        //     }
        // }
        // if(needChange){
        //     for(int i=0;i<m;i++){
        //         for(int j=0;j<n;j++){
        //             if(matrix[i][j]==-1){
        //                 matrix[i][j]=0;
        //             }
        //         }
        //     }
        // }
    }
    static void markRow(int rowNum, int[][] matrix, int colLen){
        for(int i=0;i<colLen;i++){
            if(matrix[rowNum][i]!=0){
                matrix[rowNum][i]=-1;
            }
        }
    }
    static void markCol(int colNum, int[][] matrix, int rowLen){
        for(int i=0;i<rowLen;i++){
            if(matrix[i][colNum]!=0){
                matrix[i][colNum]=-1;
            }
        }
    }
}