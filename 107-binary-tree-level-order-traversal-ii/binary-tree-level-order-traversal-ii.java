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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrderBottom = new ArrayList<>();
        if(root==null)return levelOrderBottom;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> temp = new ArrayList<>();
            while(len>0){
                TreeNode current = q.remove();
                temp.add(current.val);
                if(current.right!=null){
                    q.add(current.right);
                }
                if(current.left!=null){
                    q.add(current.left);
                }
                len--;
            }
            levelOrderBottom.add(temp);
        }
        for(int i=0;i<levelOrderBottom.size();i++){
            Collections.reverse(levelOrderBottom.get(i));
        }
        Collections.reverse(levelOrderBottom);
        return levelOrderBottom;
    }
}