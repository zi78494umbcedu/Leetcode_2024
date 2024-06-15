class Solution {
    static void stackingDFS(int node, boolean[] visited, int[] edges, int n, Stack<Integer> stack){
        visited[node]=true;
        int child = edges[node];
        if(child!=-1 && !visited[child]){
            stackingDFS(child, visited, edges, n, stack);
        }
        stack.add(node);
    }
    public int longestCycle(int[] edges) {
        //Kosaraju's algorithm
        /**
        1.sort all nodes to get the starting cycle
        2.reverse all the edges to disconnect
        3.dfs for finding cycles
        //if no outgoing edge then -1
        */
        //sorting nodes
        int n=edges.length;
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited =new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i] && edges[i]!=-1){
                stackingDFS(i, visited, edges, n, stack);
            } 
        }
        //reversing edges
        List<List<Integer>> rev= new ArrayList<>();
        for(int i=0;i<n;i++){
            rev.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            visited[i]=false;
            if(edges[i]!=-1){
                rev.get(edges[i]).add(i);
            }
        }
        //dfs for getting size of components
        int maxSize=0;
        while(!stack.isEmpty()){
            int node=stack.pop();
            if(!visited[node]){
                maxSize=Math.max(maxSize, dfs(node, visited, rev));
            }
        }
        if(maxSize<=1){
            return -1;
        }
        return maxSize;
    }

    static int dfs(int node, boolean[] visited, List<List<Integer>> adj){
        visited[node]=true;
        int size=1;
        for(int child:adj.get(node)){
            if(!visited[child]){
                size+=dfs(child, visited, adj);
            }
        }
        return size;
    }
}