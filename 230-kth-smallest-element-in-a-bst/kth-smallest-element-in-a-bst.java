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
    public int kthSmallest(TreeNode root, int k) {
        //morris inorder traversal since it gives the sorted array and stopping when found the kth elemenmt inline
        TreeNode curr =root;
        int cnt=0;
        while(curr!=null){
            
            if(curr.left==null){
                cnt++;
                if(cnt==k){
                    return curr.val;
                }
                curr=curr.right;
            }else{
                TreeNode currLeft =curr.left;
                while(currLeft.right!=null && currLeft.right!=curr){
                    currLeft =currLeft.right;
                }
                if(currLeft.right==null){
                    currLeft.right =curr;
                    curr=curr.left;
                }else{
                    cnt++;
                    if(cnt==k){
                        return curr.val;
                    }
                    
                    currLeft.right=null;
                    curr= curr.right;
                }
            }
        }
        return -1;
    }
}