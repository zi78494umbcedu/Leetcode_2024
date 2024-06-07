class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] colored=new int[n];
        Arrays.fill(colored, -1);
        //breadth first traversal - queue
        for(int i=0;i<n;i++){
            if(colored[i]==-1){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colored[i]=0;
                while(!q.isEmpty()){
                    int temp = q.poll();
                    for(int neighbour:graph[temp]){
                        if(colored[neighbour]==-1){
                            colored[neighbour]=1-colored[temp];
                            q.add(neighbour);
                        }else{
                            if(colored[temp]==colored[neighbour]){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}