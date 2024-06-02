/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        //using property of a complete tree - using height of every subtree
        //iterating, if left-height <> right-height then cannot apply 2^n-1 
        //instead 1 + left + right
        return heightDependentSize(root);
        //brute force method O(n) -> return size(root);
    }
    static int heightDependentSize(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        if(lh==rh){
            return (1<<lh)-1;
        }
        return 1+heightDependentSize(root.left)+heightDependentSize(root.right);
    } 
    static int getLeftHeight(TreeNode root){
        int h=0;
        while(root!=null){
            h++;
            root= root.left;
        }
        return h;
    }
    static int getRightHeight(TreeNode root){
        int h=0;
        while(root!=null){
            h++;
            root= root.right;
        }
        return h;
    }
    static int size(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = size(root.left);
        int right = size(root.right);
        return left+right+1;
    }
}