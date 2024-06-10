import java.util.*;



class Pair implements Comparable<Pair>{
    int distance;
    int vertex;
    public Pair(int distance, int vertex){
        this.distance=distance;
        this.vertex=vertex;
    }

    @Override
    public int compareTo(Pair other){
        return Integer.compare(this.distance, other.distance);
    }
}
public class Solution {
    public static List<Integer> dijkstra(int[][] edge,int vertices, int edges,int source){
        // negative distances make it go in infinite loop
        //breadth first approach using Priority Queue
        //O(E logV)
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges;i++){
            //weight,vertex
            adj.get(edge[i][0]).add(new Pair(edge[i][2], edge[i][1]));
            adj.get(edge[i][1]).add(new Pair(edge[i][2], edge[i][0]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] distance = new int[vertices];
        Arrays.fill(distance, (int)(1e9));
        distance[source]=0;
        pq.add(new Pair(0, source));
        while(!pq.isEmpty()){
            Pair temp= pq.poll();
            int distTemp = temp.distance;
            int nodeTemp = temp.vertex;
            for(Pair neighbour:adj.get(nodeTemp)){
                int nodeDist = neighbour.distance+distTemp;
                if(distance[neighbour.vertex]>nodeDist){
                    distance[neighbour.vertex]=nodeDist;
                    pq.add(new Pair(nodeDist, neighbour.vertex));
                }
            }
        }
        List<Integer> distances =new ArrayList<>();
        for(int i=0;i<distance.length;i++){
            distances.add(distance[i]!=(int)(1e9)?distance[i]:-1);
        }
        return distances;
    }
}
