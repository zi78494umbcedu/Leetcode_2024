/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;
class Pair{
    TreeNode node;
    int vertical;
    public Pair(TreeNode node, Integer vertical){
        this.node = node;
        this.vertical = vertical;
    }
}
public class Solution {
    public static List<Integer> getTopView(TreeNode root) {
        //O(n) -> 2 data structures, Queue<Node, vertical>, Map<vertical, Node.val,>(TreeMap for sorting based on vertical value)
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        List<Integer> topView=new ArrayList<>();
        if(root==null)return topView;
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair temp =q.poll();
            TreeNode tempNode = temp.node;
            int vertical = temp.vertical;
            if(!map.containsKey(vertical)){
                map.put(vertical, tempNode.data);
            }
            if(tempNode.left!=null){
                q.add(new Pair(tempNode.left, vertical-1));
            }
             if(tempNode.right!=null){
                q.add(new Pair(tempNode.right, vertical+1));
            }
        }
        for(Map.Entry<Integer, Integer> values: map.entrySet()){
            topView.add(values.getValue());
        }
        return topView;
    }
}
