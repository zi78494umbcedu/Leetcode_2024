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

 class BSTIterator{
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    private Boolean reverse=true;
    public BSTIterator(TreeNode root, Boolean reverse){
        this.reverse=reverse;
        pushAll(root, reverse);
    }
    public Boolean hasNext(){
        return !stack.isEmpty();
    }
    public int next(){
        if(!stack.isEmpty()){
            TreeNode next = stack.pop();
            if(!reverse){
                pushAll(next.right, false);
            }else{
                pushAll(next.left, true);
            }
            return next.val;
        }
        return -1;
    }
    private void pushAll(TreeNode root, Boolean reverse){
        for(;root!=null;){
            stack.add(root);
            if(!reverse){
                root =root.left;
            }else{
                root=root.right;
            }
        }
    }
 }
class Solution {
    public boolean findTarget(TreeNode root, int k) {
       //using two pointer approach - a BST Iterator 
       if(root==null)return false;
       BSTIterator left = new BSTIterator(root, false);
       BSTIterator right = new BSTIterator(root, true);
       int i=left.next();
       int j=right.next();
       while(i<j){
        if(i+j==k)return true;
        else if(i+j<k){
            if(left.hasNext()){
                i=left.next();
            }else{
                return false;
            }
        }
        else{
            if(right.hasNext()){
                j=right.next();
            }else{
                return false;
            }
        }
       }
       return false;
    }
}