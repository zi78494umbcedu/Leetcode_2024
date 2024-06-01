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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagTraversal = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)return zigzagTraversal;
        q.add(root);
        boolean leftOrRight=true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                int index = leftOrRight?i:size-1-i;
                if(leftOrRight){
                    temp.addLast(curr.val);
                }
                if(!leftOrRight){
                    temp.addFirst(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            leftOrRight=!leftOrRight;
            zigzagTraversal.add(temp);
        }
        return zigzagTraversal;
    }
}