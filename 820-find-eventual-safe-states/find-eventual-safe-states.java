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
        //kahn's algorithm but outdegree instead owing to terminal nodes - breadth first traversal
        //Thought: reverse edges to apply same algorithm of indegree 
        //adjacency matrix in reverse + //indegree
        List<List<Integer>> reverseAdj = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i<n;i++){
            reverseAdj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                reverseAdj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        //queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        //breadth first traversal
        List<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty()){
            int temp = q.poll();
            safeNodes.add(temp);
            for(int neighbour:reverseAdj.get(temp)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;



        // //check for cycle
        // //any node part of cycle
        // //any node leading to a cycle 
        // //for readability better to have 2 arrays and not counters
        // int n = graph.length;
        // boolean[] visited = new boolean[n];
        // boolean[] pathVisited = new boolean[n];
        // boolean[] checksSafe = new boolean[n];
        // for(int i=0;i<n;i++){
        //     if(!visited[i]){
        //         dfs(graph, visited, pathVisited, checksSafe, i);
        //     }
        // }
        // List<Integer> safeStates = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     if(checksSafe[i]){
        //         safeStates.add(i);
        //     }
        // }
        // return safeStates;
    }
}