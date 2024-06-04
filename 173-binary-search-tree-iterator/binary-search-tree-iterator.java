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
class BSTIterator {
    static Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        if(!stack.isEmpty()){
            TreeNode next = stack.pop();
            pushAll(next.right);
            return next.val;  
        }
        return -1;
      
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    private void pushAll(TreeNode node){
        for(;node!=null;stack.push(node), node=node.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */