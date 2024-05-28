class Solution {
    public void setZeroes(int[][] matrix) {
        //optimal approach optimising the space, using row, col inside given matrix with adjustments
        int col0=1;
        // boolean[] col =new boolean[m]; --> matrix[0][...]
        // boolean[] row =new boolean[n]; --> matrix[...][0]
        int m=matrix.length;
        int n = matrix[0].length;
        //step1 marking the ith row and jth col
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    //mark the ith row
                    matrix[i][0]=0;
                    //mark the jth col
                    if(j!=0){
                        matrix[0][j]=0;
                    }else{
                        col0=0;
                    }
                }
            }
        }
        //step2 marking the rest matrix to zeroes checking the ith row and jth col
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]!=0){
                    //check for the ith row and jth col
                    if(matrix[i][0]==0 || matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }
        //step3 if matrix[0][0]==0 then the matrix[0][...] will be zeroes
        if(matrix[0][0]==0){
            for(int i=0;i<n;i++){
                matrix[0][i]=0;
            }
        }
        //step4 if col0==0 then matrix[...][0] will be zeroes
        if(col0==0){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
        //better approach O(n^2)
        // int m = matrix.length;
        // int n = matrix[0].length;
        // boolean[] row =new boolean[m];
        // boolean[] col =new boolean[n];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(matrix[i][j]==0){
        //             row[i]=true;
        //             col[j]=true;
        //         }
        //     }
        // }
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(row[i] || col[j]){
        //             matrix[i][j]=0;
        //         }
        //     }
        // }
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