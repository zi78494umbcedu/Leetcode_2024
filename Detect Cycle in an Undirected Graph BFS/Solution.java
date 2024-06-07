import java.util.*;
public class Solution {
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            Queue<int[]> q = new LinkedList<>();
            boolean[] visited = new boolean[V];
            for(int i=0;i<V;i++){
                if(!visited[i]){
                    q.add(new int[]{i,-1});
                    visited[i]=true;
                    while(!q.isEmpty()){
                        int[] temp =q.poll();
                        int tempInt =temp[0];
                        int tempParent =temp[1];
                        for(int neighbour:adj.get(tempInt)){
                            if(!visited[neighbour]){
                                visited[neighbour]=true;
                                q.add(new int[]{neighbour, tempInt});
                            }else if(neighbour!=tempParent){
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
    };
}
