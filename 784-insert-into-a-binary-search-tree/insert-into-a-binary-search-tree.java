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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)return new TreeNode(val);
        TreeNode curr = root;
        while(curr!=null){
            //traversing left
            if(curr.val>val){
                if(curr.left==null){
                    TreeNode left = new TreeNode(val);
                    curr.left = left;
                    break;
                }else{
                    curr=curr.left;
                }
                
            }//traversing right
            else{
                if(curr.right==null){
                    TreeNode right = new TreeNode(val);
                    curr.right=right;
                    break;
                }else{
                    curr = curr.right;
                }
                
            }
        }
        return root;
    }
}