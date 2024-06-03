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
        //morris' inorder traversal, find left, visit root if found then check count and return
        int cnt=0;
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                cnt++;
                if(cnt==k){
                    return curr.val;
                }
                curr=curr.right;
            }else{
                TreeNode currLeft = curr.left;
                //tetherting/anti-tethering
                while(currLeft.right!=null && currLeft.right!=curr){
                    currLeft= currLeft.right;
                }
                if(currLeft.right!=null){
                    cnt++;
                    if(cnt==k){
                        return curr.val;
                    }
                    curr = curr.right;
                    currLeft.right=null;
                }else{
                    currLeft.right=curr;
                    curr = curr.left;
                }
            }
        }
        return -1;
    }
}