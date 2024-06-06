class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row= row;
        this.col=col;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int fillOnly = image[sr][sc];
        int m= image.length;
        int n = image[0].length;
        if(fillOnly==color)return image;
        boolean[][] visited=new boolean[m][n];
        bfs(image, visited,sr, sc, fillOnly, color, m, n);
        return image;
    }
    static void bfs(int[][] image,boolean[][] visited,  int row, int col, int fillOnly, int color, int m, int n){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        image[row][col]=color;
        visited[row][col]=true;
        while(!q.isEmpty()){
            Pair temp = q.poll();
            //up    row-1, col
            //right row, col+1
            //down row+1, col
            //left row, col-1
            int[] rows = {-1, 0, +1, 0};
            int[] cols = {0, +1, 0, -1};
            int r=temp.row;
            int c=temp.col;
            for(int i=0;i<rows.length;i++){
                int ru = r+rows[i];
                int cu = c+cols[i];
                if(ru>=0 && ru<m && cu>=0 && cu<n && !visited[ru][cu] && image[ru][cu]==fillOnly){
                    visited[ru][cu]=true;
                    image[ru][cu]=color;
                    q.add(new Pair(ru, cu));
                }
            }
        }
    }
}