class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //optimised binary Search O(logm*n)
        int low = 0;
        int n= matrix.length;
        int m = matrix[0].length;
        int high = n*m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int value = matrix[mid/m][mid%m];
            if(value==target)return true;
            else if(value<target)low=mid+1;
            else{
                high = mid-1;
            }
        }
        return false;

        //brute force binary search O(n*logm)
        // int n = matrix.length;
        // int m = matrix[0].length;
        // for(int i=0;i<n;i++){
        //     if(matrix[i][0]<=target && target<=matrix[i][m-1]){
        //         if(firstOccurence(matrix[i],m, target)){
        //             return true;
        //         }
        //     }
        // }
        // return false;   
    }
    static boolean firstOccurence(int[] arr, int n, int target){
        int low= 0;
        int high =  n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==target)return true;
            else if(arr[mid]>target)high = mid-1;
            else{
                low= high+1;
            }
        }
        return false;
    }
}