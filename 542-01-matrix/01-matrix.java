class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n =mat[0].length;
        boolean[][] visited=new boolean[m][n];
        int[][] distance= new int[m][n];
        //distance from nearest 0 
        //starting from zeroes and visited rest
        //row, col, steps
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && mat[i][j]==0){
                    q.add(new int[]{i, j, 0});
                    visited[i][j]=true;
                }
            }
        }
        //up row-1, col//right row, col+1//down row+1, col//left row, col-1
        int[] rows = {-1, 0, +1, 0};
        int[] cols = {0, +1, 0, -1};
        while(!q.isEmpty()){
            int row=q.peek()[0];
            int col=q.peek()[1];
            int steps=q.poll()[2];
            distance[row][col] = steps;
            for(int i=0;i<4;i++){
                int ru = row+rows[i];
                int cu = col+cols[i];
                if(ru>=0 && ru<m && cu>=0 && cu<n && !visited[ru][cu] && mat[ru][cu]==1){
                    q.add(new int[]{ru, cu, steps+1});
                    visited[ru][cu]=true;
                }
            }
        }
        return distance;



    }
}