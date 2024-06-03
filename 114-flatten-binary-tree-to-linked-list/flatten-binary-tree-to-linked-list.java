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
    static TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null)return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.add(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.right!=null){
                st.add(curr.right);
            }
            if(curr.left!=null){
                st.add(curr.left);
            }
            if(!st.isEmpty()){
                curr.right = st.peek();
            }
            curr.left=null;
        }
        // if(root==null){
        //     return;
        // }
        // flatten(root.right);
        // flatten(root.left);
        // root.right = prev;
        // root.left=null;
        // prev=root;
    }
}