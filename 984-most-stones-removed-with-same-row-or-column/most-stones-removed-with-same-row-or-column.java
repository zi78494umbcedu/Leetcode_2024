class DisjointSet{
    List<Integer> parent =new ArrayList<>();
     List<Integer> rank =new ArrayList<>();
      List<Integer> size =new ArrayList<>();

      public DisjointSet(int n){
        for(int i=0;i<=n;i++){
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
    public int removeStones(int[][] stones) {
        int maxRow=0;
        int maxCol=0;
        int n=stones.length;
        for(int i=0;i<n;i++){
            maxRow=Math.max(maxRow, stones[i][0]);
            maxCol=Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds =new DisjointSet(maxRow+maxCol+1);
        Map<Integer, Integer> stoneNodes = new HashMap<>();
        for(int i=0;i<n;i++){
            int row= stones[i][0];
            int col = stones[i][1]+maxRow+1;
            ds.unionBySize(row, col);
            stoneNodes.put(row, 1);
            stoneNodes.put(col, 1); 
        }
    
        int cnt=0;
        for(Map.Entry<Integer, Integer> it:stoneNodes.entrySet()){
            if(ds.getParent(it.getKey())==it.getKey()){
                cnt++;
            }
        }
        return n-cnt;
    }
}