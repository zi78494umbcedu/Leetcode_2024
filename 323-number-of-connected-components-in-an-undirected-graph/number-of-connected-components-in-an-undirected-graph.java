class Solution {

    static void bfs(List<List<Integer>> adj, int node, boolean[] visited, int cnt){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node]=true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int neighbour:adj.get(temp)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.add(neighbour);
                }
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        //making the adjacency matrix in ArrayList<ArrayList<Integer>> for ease
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int e=edges.length;
        for(int i=0;i<e;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        //traversal to determine cnt everytime there is a hop
        boolean[] visited = new boolean[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                cnt++;
                bfs(adj, i, visited, cnt);
            }
        }
        return cnt;
    }
}