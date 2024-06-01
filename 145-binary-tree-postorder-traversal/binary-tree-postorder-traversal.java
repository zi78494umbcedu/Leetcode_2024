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
    public List<Integer> postorderTraversal(TreeNode root) {
        return postOrder(root, new ArrayList<>());
    }
    static List<Integer> postOrder(TreeNode root, List<Integer> traversal){
        if(root==null){
            return traversal;
        }
        postOrder(root.left, traversal);
        postOrder(root.right, traversal);
        traversal.add(root.val);
        return traversal;
    }
}