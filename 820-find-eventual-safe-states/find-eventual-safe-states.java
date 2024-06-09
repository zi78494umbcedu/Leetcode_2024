class Solution {

    static boolean dfs(int[][] graph, boolean[] visited, boolean[] pathVisited, boolean[] checksSafe, int node){
        visited[node]=true;
        pathVisited[node]=true;
        checksSafe[node]=false;
        for(int neighbour: graph[node]){
            if(!visited[neighbour]){
                if(dfs(graph, visited, pathVisited, checksSafe, neighbour)){
                    return true;
                }
            }else if(pathVisited[neighbour]){
                return true;
            }
        }
        pathVisited[node]=false;
        checksSafe[node]=true;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //all the paths should lead to terminal nodes
        //check for cycle
        //any node part of cycle
        //any node leading to a cycle 
        //for readability better to have 2 arrays and not counters
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        boolean[] checksSafe = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(graph, visited, pathVisited, checksSafe, i);
            }
        }
        List<Integer> safeStates = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(checksSafe[i]){
                safeStates.add(i);
            }
        }
        return safeStates;
    }
}