class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i]=0;
        }
        for(int i=0;i<edges.length;i++){
            //undirected
            distance[edges[i][0]][edges[i][1]]=edges[i][2];
            distance[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(distance[j][i]!=Integer.MAX_VALUE && distance[i][k]!=Integer.MAX_VALUE){
                        distance[j][k]=Math.min(distance[j][k], distance[j][i]+distance[i][k]);
                    }
                }
            }
        }
        
        int city=-1;
        int minCnt=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(distance[i][j]<=distanceThreshold){
                    cnt++;
                }
            }
            if(minCnt>cnt || minCnt==cnt && i>city){
                minCnt=cnt;
                city=i;
            }
        }
        return city;
    }
}