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
    public List<Integer> inorderTraversal(TreeNode root) {
        //iterative method
        List<Integer> inOrderResult = new ArrayList<>();
        if(root==null)return inOrderResult;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(true){
            if(root!=null){
                stack.add(root);
                root=root.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                TreeNode temp = stack.pop();
                inOrderResult.add(temp.val);
                root = temp.right;
            }
        }
        return inOrderResult;
        //return inOrder(root, new ArrayList<>());
    }
    static List<Integer> inOrder(TreeNode root, List<Integer> traversal){
        if(root==null){
            return traversal;
        }
       
        inOrder(root.left, traversal);
        traversal.add(root.val);
        inOrder(root.right, traversal);
        return traversal;
    }
}