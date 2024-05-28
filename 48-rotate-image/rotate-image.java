class Solution {
    public void rotate(int[][] matrix) {
        //in place, transpose and reverse rows
        int n=matrix.length;
        //step1 - transposing - swap on either side of the principal diagonal of all elements until the edge of the matrix
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //step2 - reverse every row of the transpose matrix to rotate
        for(int i=0;i<n;i++){
            for(int j=0;j<(n/2);j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
        // //brute force -> i j ==> j, (n-1)-i
        // int n=matrix.length;
        // int[][] ans= new int[n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         ans[j][n-1-i] = matrix[i][j];
        //     }
        // }
        // matrix=ans;
    }
    
}