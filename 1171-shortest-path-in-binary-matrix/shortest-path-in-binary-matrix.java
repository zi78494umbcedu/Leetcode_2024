class Tuple{
    int first;
    int second;
    int third;
    public Tuple(int first, int second, int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //dijkstra's algorithm
        //priority queue not required since all directions stored anyway
        int n=grid.length;
        int[][] distance= new int[n][n];
        Queue<Tuple> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                distance[i][j]=(int)(1e9);
            }
        }
        if(grid[0][0]!=0)return -1;
        //distance, row, col
        q.add(new Tuple(1, 0, 0));
        //top row-1, col
        //top right row-1, col+1
        //right row, col+1
        //right bottom row+1, col+1
        //bottom row+1, col
        //bottom left row+1, col-1
        //left row, col-1
        //top left row-1, col-1
        int[] rows={-1, -1, 0, +1, +1, +1, 0, -1};
        int[] cols={0, +1, +1, +1, 0, -1, -1, -1};
        while(!q.isEmpty()){
            Tuple temp = q.poll();
            int dist = temp.first;
            int row = temp.second;
            int col = temp.third;
            if(row==(n-1) && col==(n-1))return dist;
            for(int i=0;i<8;i++){
                int ru=row+rows[i];
                int cu=col+cols[i];
                if(ru>=0 && ru<n  && cu>=0 && cu<n && grid[ru][cu]==0 && distance[ru][cu]>(1+dist)){
                    distance[ru][cu]=(1+dist);
                    q.add(new Tuple((1+dist), ru, cu));
                    
                }
            }
        }
        return -1;
    }
}