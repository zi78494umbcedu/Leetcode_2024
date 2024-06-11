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
    long first;
    long second;
    public Pair(long first, long second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        //need number of paths only
        List<List<Pair>>   adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            // node, weight
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        //priority queue storing node, distance
        //ways data structure to get ways(ways of reaching a node)
        //distance array - starting 0
        long[] distances=new long[n];
        long[] ways= new long[n];
        long mod =(int)(1e9+7);
        for (int i = 0; i < n; i++) {
            distances[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        ways[0]=1;
        distances[0]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((Comparator.comparingLong(t->t.second)));
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair temp =pq.poll();
            long node = temp.first;
            long dis = temp.second;
            for(Pair it:adj.get((int)node)){
                long adjNode = it.first;
                long edW = it.second;
                if (dis + edW < distances[(int) adjNode]) {
                    distances[(int) adjNode] = dis + edW;
                    pq.add(new Pair(adjNode, dis + edW));
                    ways[(int) adjNode] = ways[(int) node];
                } else if (dis + edW == distances[(int) adjNode]) {
                    // If multiple paths with the same length are found, add their ways
                    ways[(int) adjNode] = (ways[(int) adjNode] + ways[(int) node]) % mod;
                }
            }
        }
        return (int)(ways[n-1]%mod);
    } 
}