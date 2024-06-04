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

    static List<Integer> morrisInorder(TreeNode root, List<Integer> inorder){
        TreeNode curr= root;
        while(curr!=null){
            if(curr.left==null){
                inorder.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode currLeft=curr.left;
                while(currLeft.right!=null && currLeft.right!=curr){
                    currLeft= currLeft.right;
                }
                if(currLeft.right==null){
                    currLeft.right=curr;
                    curr=curr.left;
                }else{
                    currLeft.right=null;
                    inorder.add(curr.val);
                    curr=curr.right;
                    
                }
            }
        }
        return inorder;
    }
    static Boolean isValidBSTRange(TreeNode root, long min, long max){
        if(root==null){
            return true;
        }
        if(root.val>=max ||  root.val<=min){
            return false;
        }
        return isValidBSTRange(root.left, min, root.val) &&  isValidBSTRange(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        //Range approach - recursive
        return isValidBSTRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
        // //morris inorder traversal and then check if sorted 
        // List<Integer> morrisInorder = morrisInorder(root, new ArrayList<>());
        // int n=morrisInorder.size();
        // for(int i=0;i<n-1;i++){
        //     if(morrisInorder.get(i)>=morrisInorder.get(i+1)){
        //         return false;
        //     }
        // }
        // return true;
    }
}