class DisjointSet{
    List<Integer> parent  = new ArrayList<>();
    List<Integer> rank  = new ArrayList<>();
    List<Integer> size  = new ArrayList<>();

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
        if(parentU==parentV)return;
        int sizeU= size.get(parentU);
        int sizeV = size.get(parentV);
        if(sizeU>sizeV){
            parent.set(parentV, parentU);
            size.set(sizeU,sizeU+sizeV);
        }else{
            parent.set(parentU, parentV);
            size.set(sizeV,sizeU+sizeV);
        }
    }
    public void unionByRank(int u, int v){
        int parentU = getParent(u);
        int parentV = getParent(v);
        if(parentU==parentV)return;
        int rankU= rank.get(parentU);
        int rankV = rank.get(parentV);
        if(rankU>rankV){
            parent.set(parentV, parentU);
        }else if(rankU<rankV){
            parent.set(parentU, parentV);
        }else{
            parent.set(parentU, parentV);
            rank.set(parentV, rank.get(parentV)+1);
        }
    }
}    
class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        //number of provinces/unconnected components = provinces
        //exitisting connections/edges = connections.length
        //n-1 required to make them all connected
        //if connections.length>=n-1
        //then answer == (provinces-1)
        //get extra edges
        int extraEdges =0;
        DisjointSet ds =new DisjointSet(n);
        for(int i=0;i<connections.length;i++){
            int src = connections[i][0];
            int dest = connections[i][1];
            if(ds.getParent(src)==ds.getParent(dest)){
                extraEdges++;
            }else{
                ds.unionBySize(src, dest);
            }
        }
        //get number of provinces
        int provinces=-1;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i){
                provinces++;
            }
        }
        if(provinces<=extraEdges)return provinces;
        return -1;
    }
}