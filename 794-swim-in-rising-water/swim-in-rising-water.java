class DisjointSet{
    List<Integer> parent =new ArrayList<>();
     List<Integer> rank =new ArrayList<>();
      List<Integer> size =new ArrayList<>();

      public DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
      }
      public int getParent(int node){
        if(node==parent.get(node)){
            return node;
        }
        int interimParent = getParent(parent.get(node));
        parent.set(node, interimParent);
        return parent.get(node);
      }
      public void unionBySize(int u, int v){
        int parentU = getParent(u);
        int parentV = getParent(v);
        if(parentU==parentV)return ;
        int sizeU = size.get(parentU);
        int sizeV = size.get(parentV);
        if(sizeU>sizeV){
            parent.set(parentV,parentU);
            size.set(parentU, sizeU+sizeV);
        }else{
             parent.set(parentU,parentV);
             size.set(parentV, sizeU+sizeV);
        }
      }
      public void unionByRank(int u, int v){
        int parentU = getParent(u);
        int parentV = getParent(v);
        if(parentU==parentV)return ;
        int rankU = rank.get(parentU);
        int rankV= rank.get(parentV);
        if(rankU>rankV){
            parent.set(parentV,parentU);
        }else if(rankU<rankV){
             parent.set(parentU,parentV);
        }else{
            parent.set(parentU,parentV);
            rank.set(parentV, rank.get(parentV)+1);
        }
      }
}

class Solution {
    public int swimInWater(int[][] grid) {
        //krushal's algorithm 
        //sorting in time ascending
        //making a minimum spanning tree types union the positions
        int n=grid.length;
        if(n==1)return 0;
        DisjointSet ds = new DisjointSet(n*n);
        HashMap<Integer, int[]> map=new HashMap<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                map.put(grid[i][j], new int[]{i, j});

        int time = 0;
        while(ds.getParent(0)!=ds.getParent(n*n-1)){
            int[] node=map.get(time);
            int x=node[0];
            int y=node[1];
            int[] dx= {-1, 0, 1, 0};
            int[] dy={0, -1, 0, 1};
            for (int i = 0; i < 4; i++) {
                int nrow = x + dx[i];
                int ncol = y + dy[i];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < n && grid[nrow][ncol] <= time){
                    ds.unionBySize(nrow*n+ncol, x*n+y);
                }
            } 
            time++;
        }
        return time-1;
    }
}

