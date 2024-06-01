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
    public int diameterOfBinaryTree(TreeNode root) {
        //O(N)
        if(root==null)return 0;
        int diameter[] = new int[1];
        findDiameter(root, diameter);
        return diameter[0];
        //Brute force
        // int height=0;
        // if(root==null)return height;
        // int lh = findHeight(root.left);
        // int rh = findHeight(root.right);
        // height=Math.max(lh+rh, height);
        // diameterOfBinaryTree(root.left);
        // diameterOfBinaryTree(root.right);
        // return height;
    }
    static int findDiameter(TreeNode root, int[] maximum){
        if(root==null){
            return 0;
        }
        int lh=findDiameter(root.left, maximum);
        int rh=findDiameter(root.right, maximum);
        maximum[0]=Math.max(maximum[0], lh+rh);
        return 1+Math.max(lh, rh);
    }
    static int findHeight(TreeNode root){
        if(root==null)return 0;
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        return 1+Math.max(lh, rh);
    }
}