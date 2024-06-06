import java.util.*;

public class Solution {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        //creating graphs for all vertices
        List<Integer>[] graphs = new ArrayList[n];
        for(int i=0;i<n;i++){
            graphs[i] = new ArrayList<>();
        }
        //filling the edges for each vertex graph
        for(int i = 0;i<m;i++){
            graphs[edges[i][0]].add(edges[i][1]);
            graphs[edges[i][1]].add(edges[i][0]);
        }

        //creating adjacency matrix of size n for vertices
        int[][] adj = new int[n][];
        for(int i=0;i<n;i++){
            int graphSize = graphs[i].size();
            int[] temp = new int[graphSize+1];
            temp[0]=i;
            for(int j=0;j<graphSize;j++){
                temp[j+1] = graphs[i].get(j);
            }
            adj[i]=temp;

        }
        return adj;

        // List<List<Integer>> adj = new ArrayList<>();
        // //
        // for(int i=0;i<n;i++){
        //     List<Integer> temp = new ArrayList<>();
        //     temp.add(i); 
        //     adj.add(temp);       
        // }
        // for(int j=0;j<edges.length;j++){
        //     adj.get(edges[j][0]).add(edges[j][1]);
        //     adj.get(edges[j][1]).add(edges[j][0]);
        // }
        // int[][] adjacencyList = new int[adj.size()][adj.size()];
        // for(int i=0;i<adj.size();i++){
        //     int[] arr = new int[adj.get(i).size()];
        //     for(int j=0;j<adj.get(i).size();j++){
        //         arr[j]=adj.get(i).get(j);
        //     }
        //     adjacencyList[i]=arr;
        // }
        // return adjacencyList;
        // int[][] adjacencyMatrix = new int[n+1][n+1];
        // for(int i=0;i<edges.length;i++){
        //     for(int j=0;j<edges[0].length;j++){
        //         adjacencyMatrix[i][j]=1;
        //         adjacencyMatrix[j][i]=1;
        //     }
        // }
        // return adjacencyMatrix;

        
        
    }
}
