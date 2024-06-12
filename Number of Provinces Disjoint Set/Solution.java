//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
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
            parent.set(parentV, parentU);
            size.set(parentU, sizeU+sizeV);
        }else{
            parent.set(parentU, parentV);
            size.set(parentV, sizeU+sizeV);
        }
    }
    public void unionByRank(int u, int v){
        int parentU = getParent(u);
        int parentV = getParent(v);
        if(parentU==parentV)return ;
        int rankU = rank.get(parentU);
        int rankV = rank.get(parentV);
        if(rankU>rankV){
            parent.set(parentV, parentU);
        }else if(rankU<rankV){
            parent.set(parentU, parentV);
        }else{
            parent.set(parentU, parentV);
            rank.set(rankV, rank.get(parentV)+1);
        }
    }
    
}
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        //count distinct parents in the parents array
        //rather count number of ultimate parents how many themselves
        DisjointSet ds =new DisjointSet(V);
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1){
                    ds.unionBySize(i, j);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<V;i++){
            if(ds.getParent(i)==i){
                cnt++;
            }
        }
        return cnt;
    }
};
