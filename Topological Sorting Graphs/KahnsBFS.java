import java.util.*;
import java.io.*;
public class Solution {
  
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        //Kahn's Algorithm - Breadth First Search
        //Queue Data Structure
        //New: Indegree of nodes 
        //Step1 - creating a adjacency matrix
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        //Step2 - creating a indegree of all nodes - using adjacency matrix
        int[] indegree = new int[v];
        for(int i=0;i<v;i++){
            for(int neighbour:adj.get(i)){
                indegree[neighbour]++;
            }
        }
        //Step3 - adding the zero indegrees to a queue for BFS
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        //Step3 - popping queue and breadth first by decrementing the neighbours indegree 
        //for the neighbours will have indegree from other and the parent node
        List<Integer> topoSort = new ArrayList<>();
        while(!q.isEmpty()){
            int temp = q.poll();
            topoSort.add(temp);
            for(int neighbour:adj.get(temp)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        } 
        return topoSort;
    }

}
