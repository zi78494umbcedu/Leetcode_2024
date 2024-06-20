class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int row = 0; 
        int col = grid[0].length-1;
        int count = 0;
        //counting in only one way since it is sorted 
        /**
         4  3  2  -1
         3  2  1  -1
         1  1 -1  -2
        -1 -1 -2  -3
        */
        //start from right top
        //for row check., if row is positive, move down to get decreasing number
        //for colum check., faster move since if found negative then all the columns on the left negative
        while(row < rows && col >= 0){
            if(grid[row][col] >= 0){
                row++;
            } else {
                count += rows-row;
                col--;
            }
        }
        return count;
    }
}
