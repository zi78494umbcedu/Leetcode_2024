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
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //cheapest!=shortest
        //number of stops important and not the distance
        //thus not Dijkstra's exactly with a priority queue
        //but a similar algorithm with a 
        //1.distance data structure and 
        //2.a queue with number of stops priority
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        int[] distances = new int[n];
        Arrays.fill(distances, (int)(1e9));
        //stops, node, distance
        q.add(new Tuple(0, src, 0));
        distances[src]=0;
        while(!q.isEmpty()){
            Tuple temp =q.poll();
            int stops= temp.first;
            int node = temp.second;
            int distance = temp.third;
            for(Pair neighbour:adj.get(node)){
                int dist = neighbour.second+distance;
                int airport=neighbour.first;
                if(stops<=k && dist<distances[airport]){
                    q.add(new Tuple(stops+1, airport, dist));
                    distances[airport]=dist;
                }
            }
        }
        if(distances[dst]==(1e9))return -1;
        return distances[dst];
    }
}