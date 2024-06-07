class Solution {
    static boolean dfs(int node,int color,  int[][] graph, int[] colored, int n){
        colored[node]=color;
        for(int adj:graph[node]){
            if(colored[adj]==-1){
                if(!dfs(adj, 1-colored[node], graph, colored, n)){
                    return false;
                }
            }else if(colored[adj]==color){
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        //Depth First Traversal 
        int n=graph.length;
        int[] colored = new int[n];
        Arrays.fill(colored, -1);
        //accommodating for components
        for(int i=0;i<n;i++){
            if(colored[i]==-1){
                if(!dfs(i,0,  graph, colored, n)){
                    return false;
                }
            }
        }   
        return true;
        //Breadth First Traversal
        // int n=graph.length;
        // int[] colored=new int[n];
        // Arrays.fill(colored, -1);
        // //breadth first traversal - queue
        // for(int i=0;i<n;i++){
        //     if(colored[i]==-1){
        //         Queue<Integer> q = new LinkedList<>();
        //         q.add(i);
        //         colored[i]=0;
        //         while(!q.isEmpty()){
        //             int temp = q.poll();
        //             for(int neighbour:graph[temp]){
        //                 if(colored[neighbour]==-1){
        //                     colored[neighbour]=1-colored[temp];
        //                     q.add(neighbour);
        //                 }else{
        //                     if(colored[temp]==colored[neighbour]){
        //                         return false;
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
        // return true;
    }
}