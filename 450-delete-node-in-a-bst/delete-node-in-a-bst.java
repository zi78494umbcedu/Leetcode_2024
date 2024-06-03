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

    static TreeNode helper(TreeNode root){
        if(root.left==null){
            return root.right;
        }
        else if(root.right==null){
            return root.left;
        }
        TreeNode rightChild = root.right;
        TreeNode lastRight = findLast(root.left);
        lastRight.right =rightChild;
        return root.left;
    }
    static TreeNode findLast(TreeNode root){
        while(root.right!=null){
            root = root.right;
        }
        return root;

    }
    public TreeNode deleteNode(TreeNode root, int key) {
        //finding the node
        //deleting the node
            //de-tether part of it
            //attach the de-tethered part to the end of the relevant side of the tethered part
        //OR
        //find and delete in the same traversal
        if(root==null)return null;
        TreeNode dummy = root;
        //case when root itself is the key 
        if(root.val==key){
            return helper(root);
        }
        while(root!=null){
            if(root.val>key){
                if(root.left!=null && root.left.val==key){
                    root.left=helper(root.left);
                    break;
                }else{
                    root=root.left;
                }
            }else{
                if(root.right!=null && root.right.val==key){
                    root.right=helper(root.right);
                    break;
                }
                else{
                    root=root.right;
                }
            }
        }
        return dummy;
    }
}