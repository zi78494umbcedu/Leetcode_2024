public final class Solution {
    public static int findMedian(int matrix[][], int m, int n) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int req = (m*n)/2;
        int na = matrix.length;
        int ma = matrix[0].length;
        for(int i=0;i<na;i++){
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][ma-1]);
        }
        while(low<=high){
            int mid = (low+high)>>1;
            int cnt = smallerCount(matrix, mid);
            if(cnt<=req)low = mid+1;
            else{
                high = mid-1;
            }
        }
        return low;
    }

    static int upperBound(int[] matrix, int bound){
        int low =0;
        int high = matrix.length-1;
        while(low<=high){
            int mid = (low+high)>>1;
            if(matrix[mid]<=bound){
                low=mid+1;
            }else{
                high= mid-1;
            }
        }
        return low;
    }
    static int smallerCount(int[][] matrix, int mid){
        int cnt = 0;
        for(int i=0;i<matrix.length;i++){
            cnt+=upperBound(matrix[i], mid);
        }
        return cnt;
    }
}
