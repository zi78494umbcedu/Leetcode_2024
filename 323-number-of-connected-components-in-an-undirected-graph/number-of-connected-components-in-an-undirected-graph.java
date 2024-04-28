class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        boolean[] visited = new boolean[n];
        int connt=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                connt++;
                visited[i]=true;
                markAllConnected(visited, i, adj);
            }
        }
        return connt;
    }
    public static void markAllConnected(boolean[] visited, int i, ArrayList<ArrayList<Integer>> adj){
       Queue<Integer> q = new LinkedList<>();
       q.add(i);
       while(!q.isEmpty()){
        int current = q.poll();
        for(int neighbour: adj.get(current)){
            if(!visited[neighbour]){
                visited[neighbour] = true;
                q.add(neighbour);
            }
        }
       }
    }
    
}