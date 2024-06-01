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
        //iterative method
        List<Integer> preOrderResult = new ArrayList<>();
        if(root==null)return preOrderResult;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            preOrderResult.add(temp.val);
            if(temp.right!=null){
                stack.add(temp.right);
            }
            if(temp.left!=null){
                stack.add(temp.left);
            }
        }
        return preOrderResult;
        //return preOrder(root, new ArrayList<>());
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