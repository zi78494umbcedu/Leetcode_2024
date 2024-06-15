class Solution {
    private static int timer;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //update the time of insertion & lowest time of insertion of all adjacent nodes apart from the parent
        //retract path to get the critical connections comparing the times - e.g.,
        // one node cant be reached by anywhere else -> if the edge is removed it is disconnected
        //Tarjan's Algorithm
        //adjacency graph
        timer=1;
        List<List<Integer>> adj = new ArrayList<>();
        //0-based
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int edges  = connections.size();
        for(int i=0;i<edges;i++){
            //undirected
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        boolean[] visited= new boolean[n];
        //time of insertion
        int[] tin = new int[n];
        //lowest time of all adjacent nodes except parent for it can be a critical bridge b/w parent and the node
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(0, -1, adj, bridges, visited, tin, low);
            }
        }
        
        return bridges;
    }
    static void dfs(int node, int parent, List<List<Integer>> adj, List<List<Integer>> bridges, boolean[] visited, int[] tin, int[] low){
        visited[node]=true;
        tin[node]=low[node]=timer++;

        for(int neighbour:adj.get(node)){
            if(neighbour==parent)continue;
            if(!visited[neighbour]){
                dfs(neighbour, node, adj, bridges, visited, tin, low);
                low[node]=Math.min(low[neighbour], low[node]);
                //if neighbour cannot reach in time of the parent 
                if(low[neighbour]>tin[node]){
                    bridges.add(Arrays.asList(neighbour, node));
                }
            }else{
                low[node]=Math.min(low[node], low[neighbour]);
            }
        }
    }
}