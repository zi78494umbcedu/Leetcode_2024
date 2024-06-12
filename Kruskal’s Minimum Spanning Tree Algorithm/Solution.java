import java.util.*;

class DisjointSet{
    //for dynamic graphs
    //getParent() & union()-> by rank/size
    //Use Case:
    //  constant time operation 
    //  to find if two nodes are connected 
    //  instead of ElogV of BFS?DFS
    //Algorithm
    //two arrays  - parent, rank/size
    //initially - everybody their own parent
    //initially - everybody rank 0
    //initially - everybody size 1
    //union(u, v) logic
    /**
    1.find ultimate parent of u & v -> pu, pv
    2.find rank of pu & pv
    3.connect smaller rank to the bigger rank always - for minimum time taken and keeping the graph short
    //getParent()
    1.path compression for finding parent in O(4*alpha)=>O(1)
    2.change link directly to ultimate parent
    */
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int node){
        if(node==parent.get(node)){
            return node;
        }
        int interimParent = findParent(parent.get(node));
        parent.set(node, interimParent);
        return parent.get(node);
    }
    public void unionByRank(int u, int v){
        int parentU=findParent(u);
        int parentV=findParent(v);
        if(parentU==parentV)return;
        if(rank.get(parentU)<rank.get(parentV)){
            parent.set(parentU, parentV);
        }else if(rank.get(parentU)>rank.get(parentV)){
            parent.set(parentV, parentU);
        }else{
            parent.set(parentV, parentU);
            rank.set(parentU, rank.get(parentU)+1);
        }
    }
    public void unionBySize(int u, int v){
        int parentU=findParent(u);
        int parentV=findParent(v);
        if(parentU==parentV)return;
        int sizeU = size.get(parentU);
        int sizeV = size.get(parentV);
        if(sizeU<sizeV){
            parent.set(parentU, parentV);
            size.set(parentV, sizeU+sizeV);
        }
        else{
            parent.set(parentV, parentU);
            size.set(parentU, sizeU+sizeV);
        }
    }


}
class Tuple implements Comparable<Tuple>{
    int first;int second;int third;
    public Tuple(int first, int second, int third){
        this.first=first;this.second=second;this.third=third;
    }
    public int compareTo(Tuple tuple){
        return this.third-tuple.third;
    }
}    
public class Solution {
    public static int kruskalMST(int n,int [][]edges) {
        //sort all the edges with weight
        //use disjoint set and check if two nodes belong to same component
        //if same component that means already attached to the MST, thus continue
        //Note: DISJOINT SET IGNORES/TAKES-CARE OF THE BIDIRECTIONAL PROPERTY OF GRAPH
        List<Tuple> edgesAdj= new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            edgesAdj.add(new Tuple(edges[i][0], edges[i][1], edges[i][2]));
        }
        DisjointSet ds = new DisjointSet(n);
        Collections.sort(edgesAdj);
        int minWeight=0;
        for(int i=0;i<edgesAdj.size();i++){
            int src=edgesAdj.get(i).first;
            int dest=edgesAdj.get(i).second;
            int weight=edgesAdj.get(i).third;
            if(ds.findParent(src)!=ds.findParent(dest)){
                minWeight+=weight;
                ds.unionBySize(src, dest);
            }
        }
        return minWeight;
    }
}
