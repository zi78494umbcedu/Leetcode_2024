import java.util.*;

class Pair{
	int first;
	int second;
	public Pair(int first, int second){
		this.first=first;
		this.second=second;
	}
}
public class Solution {

	public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
		//Minimum Spanning Tree
		//1.N nodes
		//2.N-1 edges
		//3.all nodes are reachable from each other
		//Prim's Algorithm - Greedy, Priority Queue

		//adjacency list
		List<List<Pair>> adj = new ArrayList<>();
		for(int i=0;i<n;i++){
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<edges.size();i++){
			//undirected
			//weight, node
			adj.get(edges.get(i).get(0)).add(new Pair(edges.get(i).get(2), edges.get(i).get(1)));
			adj.get(edges.get(i).get(1)).add(new Pair(edges.get(i).get(2), edges.get(i).get(0)));
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(t->t.first));
		boolean[] visited = new boolean[n];
		int mstSum=0;
		//weight, node
		pq.add(new Pair(0,0));
		while(!pq.isEmpty()){
			Pair temp = pq.poll();
			int weight= temp.first;
			int node = temp.second;
			if(visited[node])continue;
			visited[node]=true;
			mstSum+=weight;
			
			for(Pair neighbour:adj.get(node)){
				int neighbourNode= neighbour.second;
				int neighbourWeight = neighbour.first;
				if(!visited[neighbourNode]){
					pq.add(new Pair(neighbourWeight, neighbourNode));
				}
			}
		}
		return mstSum;
	}
}
