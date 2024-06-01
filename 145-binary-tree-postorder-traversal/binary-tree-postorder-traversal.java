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
        //iterative using 1 stack
        List<Integer> postOrderResult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null)return postOrderResult;
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.add(curr);
                curr=curr.left;
            }
            else{
                TreeNode temp = stack.peek().right;
                if(temp==null){
                    temp = stack.pop();
                    postOrderResult.add(temp.val);
                    while(!stack.isEmpty() && temp==stack.peek().right){
                        temp = stack.pop();
                        postOrderResult.add(temp.val);
                    }
                }
                else{
                    curr=temp;
                }
            }
        }
        return postOrderResult;

        // //iterative method 2 stacks like Hanoi Tower
        // Stack<TreeNode> stack1 = new Stack<TreeNode>();
        // Stack<TreeNode> stack2 = new Stack<TreeNode>();
        // List<Integer> postOrderResult = new ArrayList<>();
        // if(root==null)return postOrderResult;
        // stack1.add(root);
        // while(!stack1.isEmpty()){
        //     TreeNode temp =stack1.pop();
        //     stack2.add(temp);
        //     if(temp.left!=null)stack1.add(temp.left);
        //     if(temp.right!=null)stack1.add(temp.right);
        // }
        // while(!stack2.isEmpty()){
        //     postOrderResult.add(stack2.pop().val);
        // }
        // return postOrderResult;

        // //return postOrder(root, new ArrayList<>());
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