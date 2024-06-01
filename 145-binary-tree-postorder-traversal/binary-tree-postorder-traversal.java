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
        //iterative method 2 stacks like Hanoi Tower
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        List<Integer> postOrderResult = new ArrayList<>();
        if(root==null)return postOrderResult;
        stack1.add(root);
        while(!stack1.isEmpty()){
            TreeNode temp =stack1.pop();
            stack2.add(temp);
            if(temp.left!=null)stack1.add(temp.left);
            if(temp.right!=null)stack1.add(temp.right);
        }
        while(!stack2.isEmpty()){
            postOrderResult.add(stack2.pop().val);
        }
        return postOrderResult;

        //return postOrder(root, new ArrayList<>());
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