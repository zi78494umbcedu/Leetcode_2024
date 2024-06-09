class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
          //kahn's algorithm of breadth first traversal for checking if topo sort possible
          //to check if it is a Directed Acyclic graph(DAG) - only then prerequisites conditions can be met
          //Step1 Adjacency matrix
          List<List<Integer>> adj = new ArrayList<>();
          for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
          }
          for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
          }
          //Step2 Indegree for all courses for prerequisites
          int[] indegree = new int[numCourses];
          for(int i=0;i<numCourses;i++){
            for(int neighbour: adj.get(i)){
                indegree[neighbour]++;
            }
          }
          //Step3 adding all 0 prerequisites requiring courses to the queue for a Breath first traversal
          Queue<Integer> q =new LinkedList<>();
          for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
          }
          //creating a topo sort
          //List<Integer> topoSort = new ArrayList<>();
          int cnt=0;
          while(!q.isEmpty()){
            int temp= q.poll();
            cnt++;
            //traversing breadth by decrementing indegree of neighbour
            for(int neighbour:adj.get(temp) ){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
          }
          if(cnt==numCourses){
            return true;
          }
          return false;
    }
}