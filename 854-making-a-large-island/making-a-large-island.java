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
    public int largestIsland(int[][] grid) {
        //Step1: make the disjoint set for the given grid first
        //top row-1, col
        //right row, col+1
        //bottom row+1, col
        //left row, col-1
        int n=grid.length;
        int[] rows={-1, 0, +1, 0};
        int[] cols={0, +1, 0, -1};
        DisjointSet ds = new DisjointSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)continue;
                for(int pos=0;pos<4;pos++){
                    int ru = i+rows[pos];
                    int cu = j+cols[pos];
                    if(ru>=0 && ru<n && cu>=0 && cu<n && grid[ru][cu]==1){
                        int node1= i*n+j;
                        int node2 = ru*n+cu;
                        ds.unionBySize(node1, node2);
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    Set<Integer> set = new HashSet<>();
                    for(int ptr=0;ptr<4;ptr++){
                        int ru=i+rows[ptr];
                        int cu=j+cols[ptr];
                        //keeping unique ultimate parents
                        if(ru>=0 && ru<n && cu>=0 && cu<n && grid[ru][cu]==1){
                            set.add(ds.getParent(ru*n+cu));
                        }
                    }
                    int islandSize=0;
                    for(int parent:set){
                        islandSize+=ds.size.get(parent);
                    }
                    max=Math.max(max, islandSize+1);
                }
            }
        }
        for(int cell=0;cell<n*n;cell++){
            max=Math.max(max, ds.size.get(ds.getParent(cell)));
        }
        return max;
    }
}