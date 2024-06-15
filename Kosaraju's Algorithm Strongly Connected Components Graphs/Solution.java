import java.util.*;

public class Solution {
	public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {
		// Kosaraju's Algorithm for strongly connected components in a graph
		/*
		1.Sort all the nodes based on time - to get the first most component's start
		2.reverse all the edges, for the components become unreachable
		3.DFS on all nodes to get the components/count
		*/
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0;i<v;i++){
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<edges.size();i++){
			adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
		}
		//Step 1 -> sort the graph based on a dfs/timelines, in a stack
		boolean[] visited1 = new boolean[v]; 
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<v;i++){
			if(!visited1[i]){
				addingDFSstack(stack, i, adj, visited1);
			}
		}
		//Step2 -> reverse edges
		List<List<Integer>> reverseAdj = new ArrayList<>();
		for(int i=0;i<v;i++){
			reverseAdj.add(new ArrayList<>());
		}
		for(int i=0;i<edges.size();i++){
			reverseAdj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
		}
		//Step3 -> dfs to count number of components
		int components=0;
		boolean[] visited = new boolean[v];
		while(!stack.isEmpty()){
			int node = stack.pop();
			if(!visited[node]){
				dfs(node, reverseAdj, visited);
				components++;
			}
		}
		return components;
	}
	static void addingDFSstack(Stack<Integer> stack, int node, List<List<Integer>> adj, boolean[] visited){
		visited[node]=true;
		for(int neighbour: adj.get(node)){
			if(!visited[neighbour]){
				addingDFSstack(stack, neighbour, adj, visited);
			}
		}
		stack.add(node);
	}
	static void dfs(int node, List<List<Integer>> adj, boolean[] visited){
		visited[node]=true;
		for(int neighbour:adj.get(node)){
			if(!visited[neighbour]){
				dfs(neighbour, adj, visited);
			}
		}
	}
}
