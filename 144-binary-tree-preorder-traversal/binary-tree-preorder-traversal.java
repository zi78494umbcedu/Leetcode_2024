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
    public List<Integer> preorderTraversal(TreeNode root) {
        return preOrder(root, new ArrayList<>());
    }
    static List<Integer> preOrder(TreeNode root, List<Integer> traversal){
        if(root==null){
            return traversal;
        }
        traversal.add(root.val);
        preOrder(root.left, traversal);
        preOrder(root.right, traversal);
        return traversal;
    }
}