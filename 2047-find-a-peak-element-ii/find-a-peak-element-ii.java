class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m-1;
        while(low<=high){
            int mid= (low+high)/2;
            int maxElemIndex = getMaxColRow(mat, n, m, mid);
            int left =  mid-1>=0?mat[maxElemIndex][mid-1]:-1;
            int right = mid+1<m?mat[maxElemIndex][mid+1]:-1;
            if(mat[maxElemIndex][mid]>left && right<mat[maxElemIndex][mid])return new int[]{maxElemIndex, mid};
            else if(mat[maxElemIndex][mid]<left)high = mid-1;
            else low =mid+1;
        }
        return new int[]{-1, -1};
    }

    static int getMaxColRow(int[][] matrix, int n, int m, int mid){
        int maxElem = 0;
        int index = -1;
        for(int i=0;i<n;i++){
            if(matrix[i][mid]>maxElem){
                maxElem = matrix[i][mid];
                index = i;
            }
        }
        return index;
    }

}