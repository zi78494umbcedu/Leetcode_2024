class Tuple{
    int first;
    int second;
    int third;
    public Tuple(int first, int second, int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //dijkstra's with queue since unit step
        //scanning through the minimum distances in the end to return -1
        //maximum from the distances is the answer
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            //directed graph
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        int[] distances = new int[n+1];
        Arrays.fill(distances, (int)(1e9));
        //PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(t->t.first));
        Queue<Pair> q = new LinkedList<>();
        //steps, node, distance
        q.add(new Pair(k, 0));
        distances[k]=0;
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int node =temp.first;
            int dist=temp.second;
            for(Pair neighbour: adj.get(node)){
                int d = neighbour.second+dist;
                if(d<distances[neighbour.first]){
                    distances[neighbour.first]=d;
                    q.add(new Pair(neighbour.first, d));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(distances[i]==(1e9)){
                return -1;
            }
            max=Math.max(max, distances[i]);
        }
        return  max;
    }
}