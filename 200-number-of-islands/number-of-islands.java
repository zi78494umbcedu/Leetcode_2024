class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x= x;
        this.y=y;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        /**
        visited array of m*n 
        bfs using a queue with 4 directions
        count of islands on starting nodes of islands
        */
        int m=grid.length;
        int n = grid[0].length;
        boolean[] visited = new boolean[m*n+1];
        int islands =0;
        Queue<Pair> q = new LinkedList<>();
        int[] du = {0, +1, 0, -1};
        int[] dy = {+1, 0, -1, 0};
        for(int t=0;t<m;t++){
            for(int o=0;o<n;o++){
                if(grid[t][o]=='1' && !visited[t*n+o]){
                    visited[t*n+o]=true;
                    q.add(new Pair(t, o));
                    islands++;
                    while(!q.isEmpty()){
                        Pair pair = q.poll();
                        int xu = pair.x;
                        int yu = pair.y;
                        for(int i=0;i<4;i++){
                            int xv = xu+du[i];
                            int yv = yu+dy[i];
                            if(xv>=0 && xv<m && yv>=0 && yv<n && grid[xv][yv]=='1' && !visited[xv*n+yv]){
                                q.add(new Pair(xv, yv));
                                visited[xv*n+yv]=true;
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}