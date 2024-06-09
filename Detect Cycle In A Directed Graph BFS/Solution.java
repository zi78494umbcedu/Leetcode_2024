import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    //using Kahn's Breadth First approach for topo sort
    //no topo sort possible containing all nodes 
    //since queue gets empty beforehand 
    //due to pending dependencies not taken care of
    //adjacency matrix
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0;i<n;i++){
      adj.add(new ArrayList<>());
    }
    for(ArrayList<Integer> edge:edges){
      adj.get(edge.get(0)-1).add(edge.get(1)-1);
    }
    //indegree for all nodes
    int[] indegree=new int[n];
    for(int i=0;i<n;i++){
      for(int neighbour:adj.get(i)){
        indegree[neighbour]++;
      }
    }
    //add all 0 indegrees to queue
    Queue<Integer> q =new LinkedList<>();
    for(int i=0;i<n;i++){
      if(indegree[i]==0){
        q.add(i);
      }
    }
    //polling queue and breath first search 
    // counter instead of extra space//List<Integer> topoSort = new ArrayList<>();
    int cnt=0;
    while(!q.isEmpty()){
      int temp = q.poll();
      cnt++;
      for(int neighbour:adj.get(temp)){
        indegree[neighbour]--;
        if(indegree[neighbour]==0){
          q.add(neighbour);
        }
      }
    }
    //if topo sort is getting created then there is no extra depedency/cycle
    if(cnt==n)return false;
    return true;
  }
}
