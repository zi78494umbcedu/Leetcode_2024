/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.*;
public class Solution {

    static List<Integer> preOrderTraversal(TreeNode root, List<Integer> temp){
        if(root==null){
            return temp;
        }
        temp.add(root.data);
        preOrderTraversal(root.left, temp);
        preOrderTraversal(root.right, temp);
        return temp;
    }
    static List<Integer> inOrderTraversal(TreeNode root, List<Integer> temp){
        if(root==null){
            return temp;
        }
        inOrderTraversal(root.left, temp);
        temp.add(root.data);
        inOrderTraversal(root.right, temp);
        return temp;
    }
    static List<Integer> postOrderTraversal(TreeNode root, List<Integer> temp){
        if(root==null){
            return temp;
        }
        postOrderTraversal(root.left, temp);
        postOrderTraversal(root.right, temp);
        temp.add(root.data);
        return temp;
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> traversals = new ArrayList<>();
        if(root==null)return traversals;
        traversals.add(inOrderTraversal(root, new ArrayList<>()));
        traversals.add(preOrderTraversal(root, new ArrayList<>()));
        traversals.add(postOrderTraversal(root, new ArrayList<>()));
        return traversals;
    }
}
