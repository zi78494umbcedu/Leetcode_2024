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
        //improving space Morris threading traversal
        TreeNode curr= root;
        while(curr!=null){
            if(curr.left!=null){
                //forming thread with right-most to the curr
                TreeNode prev =curr.left;
                while(prev.right!=null){
                    prev =prev.right;
                }
                prev.right =curr.right;
                curr.right = curr.left;
                curr.left= null;
            }
            curr= curr.right;
        }
        
        //avoiding recursion
        // if(root==null)return;
        // Stack<TreeNode> st = new Stack<TreeNode>();
        // st.add(root);
        // while(!st.isEmpty()){
        //     TreeNode curr = st.pop();
        //     if(curr.right!=null){
        //         st.add(curr.right);
        //     }
        //     if(curr.left!=null){
        //         st.add(curr.left);
        //     }
        //     if(!st.isEmpty()){
        //         curr.right = st.peek();
        //     }
        //     curr.left=null;
        // }
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