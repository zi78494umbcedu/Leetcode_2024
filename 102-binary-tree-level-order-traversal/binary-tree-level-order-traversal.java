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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root==null)return levelOrder;
        while(!q.isEmpty()){
            int len =q.size();
            List<Integer> temp = new ArrayList<>();
            while(len>0){
                TreeNode current = q.remove();
                temp.add(current.val);
                if(current.left!=null){
                    q.add(current.left);
                }
                if(current.right!=null){
                    q.add(current.right);
                }
                len--;
            }
            levelOrder.add(temp);
        }
        return levelOrder;
    }
}