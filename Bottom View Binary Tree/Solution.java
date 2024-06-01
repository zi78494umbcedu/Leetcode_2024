/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    
     TreeNode(int val) {
         this.val = val;
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
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> bottomView =new ArrayList<>();
        if(root==null) return bottomView;
        Queue<Pair> q= new  LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair temp = q.remove();
            TreeNode tempNode =temp.node;
            int vertical = temp.vertical;
            map.put(vertical, tempNode.val);
            if(tempNode.left!=null){
                q.add(new Pair(tempNode.left, vertical-1));
            }
            if(tempNode.right!=null){
                q.add(new Pair(tempNode.right, vertical+1));
            }
        }
        for(Map.Entry<Integer, Integer> values: map.entrySet()){
            bottomView.add(values.getValue());
        }
        return bottomView;
    }
}
