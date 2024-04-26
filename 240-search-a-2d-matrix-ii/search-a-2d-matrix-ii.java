class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //best approach, finding pattern for a sorted matrix
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target)return true;
            else if(matrix[row][col]<target)row++;
            else col--;
        }
        return false;



        //better approach
        // int n = matrix.length;
        // int m = matrix[0].length;
        // for(int i=0;i<n;i++){
        //     if(matrix[i][0]<=target && target<=matrix[i][m-1]){
        //         if(occurrenceTarget(matrix[i], target)){return true;}
        //     }
        // }
        // return false;
    }
    static boolean occurrenceTarget(int[] matrix, int target){
        int low = 0;
        int high = matrix.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[mid]==target)return true;
            else if(matrix[mid]<target)low = mid+1;
            else{
                high  =mid-1;
            }
        }
        return false;
    }
}