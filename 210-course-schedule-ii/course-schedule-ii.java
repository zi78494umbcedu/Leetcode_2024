class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Kahn's algorithm for checking if prerequisites can be met
        //a breadth first traversal using a queue
        //adjacency
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //indegree
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int neighbour:adj.get(i)){
                indegree[neighbour]++;
            }
        }
        //adding terminals to queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        //breadth first traversal
        int[] topoSort = new int[numCourses];
        int  i=0;
        while(!q.isEmpty()){
            int temp =q.poll();
            topoSort[i++]=temp;
            for(int neighbour:adj.get(temp)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        if(i==numCourses)return topoSort;
        return new int[]{};
    }
}