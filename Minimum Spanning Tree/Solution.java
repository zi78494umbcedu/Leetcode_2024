import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Comparator;


class Pair{
	int first;
	int second;
	public Pair(int first, int second){
		this.first = first;
		this.second= second;
	}
}
public class Solution {

	public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
		//Prim's algorithm - undirected graph 
		//minimum spanning tree
		/**
		tree  - n nodes and n-1 edges and all nodes can be reached
		find the minimum distanced edges tree
		Use = Priority queues on edge weight/distance[node]
		Use = visited node - update visited only when added to the MST data structure, 
		add only when taking out of the PQ
		keep adding neighbours for PQ to filter the minimum weighted edge
		*/ 
		//adjacency matrix
		List<List<Pair>> adj = new ArrayList<>();
		//zero based graph
		for(int i=0;i<n;i++){
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<edges.size();i++){
			//undirected graph
			adj.get(edges.get(i).get(0)).add(new Pair(edges.get(i).get(2), edges.get(i).get(1)));
			adj.get(edges.get(i).get(1)).add(new Pair(edges.get(i).get(2), edges.get(i).get(0)));
		}
		//weight, node
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(t->t.first));
		//visited data structure
		boolean[] visited = new boolean[n];
		//mst data structure
		int minWeight=0;
		//initialising
		pq.add(new Pair(0, 0));
		while(!pq.isEmpty()){
			Pair temp = pq.poll();
			int tempWeight= temp.first;
			int tempNode = temp.second;
			if(visited[tempNode])continue;
			visited[tempNode]=true;
			minWeight+=tempWeight;
			for(Pair neighbour: adj.get(tempNode)){
				int weightNeighbour=neighbour.first;
				int nodeNeighbour=neighbour.second;
				pq.add(new Pair(weightNeighbour, nodeNeighbour));
			}
		} 
		return minWeight;
	}
}
