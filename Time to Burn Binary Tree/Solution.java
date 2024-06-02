import java.util.*;

/**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

*********************************************************/

public class Solution
{
	static BinaryTreeNode getParents(BinaryTreeNode root, Map<BinaryTreeNode, BinaryTreeNode> parentsMap, int start){
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);
		BinaryTreeNode startNode=new BinaryTreeNode<>(-1);
		while(!q.isEmpty()){
			BinaryTreeNode temp = q.poll();
			if(temp.data.equals(start))startNode = temp;
			if(temp.left!=null){
				parentsMap.put(temp.left, temp);
				q.add(temp.left);
			}
			if(temp.right!=null){
				parentsMap.put(temp.right, temp);
				q.add(temp.right);
			}
		}
		return startNode;
	}
public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
		//similar to distance k from target, 
		//change is instead of stopping at distance==k, 
		//continue counter until the q is empty===tree is burnt completely
		Map<BinaryTreeNode, BinaryTreeNode> parentsMap = new HashMap<>();
		BinaryTreeNode startNode = getParents(root, parentsMap, start);
		int time=0;
		Queue<BinaryTreeNode> q = new LinkedList<>();
		Map<BinaryTreeNode, Boolean> visited = new HashMap<>();
		q.add(startNode);
		visited.put(startNode, true);
		while(!q.isEmpty()){
			int size = q.size();
			Boolean branchBurnt=false;
			for(int i=0;i<size;i++){
				BinaryTreeNode temp = q.poll();
				if(temp.left!=null && visited.get(temp.left)==null){
					visited.put(temp.left, true);
					q.add(temp.left);
					branchBurnt=true;
				}
				if(temp.right!=null && visited.get(temp.right)==null){
					visited.put(temp.right, true);
					q.add(temp.right);
					branchBurnt=true;
				}
				if(parentsMap.get(temp)!=null && visited.get(parentsMap.get(temp))==null){
					visited.put(parentsMap.get(temp), true);
					q.add(parentsMap.get(temp));
					branchBurnt=true;
				}
			}
			if(branchBurnt)time++;
		}
		return time;
    }
}
