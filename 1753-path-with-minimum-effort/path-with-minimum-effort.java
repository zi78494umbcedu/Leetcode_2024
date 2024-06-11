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
    public int minimumEffortPath(int[][] heights) {
        //dijkstra's algorithm
        //priority queue not required since all directions stored anyway
        int n=heights.length;
        int m=heights[0].length;
        int[][] efforts= new int[n][m];
        //max of effort, row, col
        PriorityQueue<Tuple> q = new PriorityQueue<>((a, b)-> a.first-b.first);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                efforts[i][j]=(int)(1e9);
            }
        }
        //distance, row, col
        q.add(new Tuple(0, 0, 0));
        efforts[0][0]=0;
        //top row-1, col
        //right row, col+1
        //bottom row+1, col
        //left row, col-1
        int[] rows={-1, 0, +1, 0};
        int[] cols={0, +1, 0, -1};
        while(!q.isEmpty()){
            Tuple temp = q.poll();
            int effort = temp.first;
            int row = temp.second;
            int col = temp.third;
            if(row==(n-1) && col==(m-1))return effort;
            for(int i=0;i<4;i++){
                int ru=row+rows[i];
                int cu=col+cols[i];
                if(ru>=0 && ru<n  && cu>=0 && cu<m){
                    int nowEffort = Math.abs(heights[ru][cu]-heights[row][col]);
                    int maxEffort = Math.max(effort, nowEffort);
                    if(efforts[ru][cu]>maxEffort){
                        efforts[ru][cu] = maxEffort;
                        q.add(new Tuple(maxEffort, ru, cu));
                    }
                }
            }
        }
        return -1;
    }
}