/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //O(H) - using height factor of binary search tree until a diversion found that p on one side and q on other
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
        //O(N)
        //finding root and returning
        // if(root==null || root==p || root==q){
        //     return root;
        // }
        // TreeNode left = lowestCommonAncestor(root.left, p, q);
        // TreeNode right = lowestCommonAncestor(root.right, p, q);
        // //going back after traversal
        // if(left==null){
        //     return right;
        // }else if(right==null){
        //     return left;
        // }else{
        //     return root;
        // }
    }
}