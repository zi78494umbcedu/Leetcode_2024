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
        List<List<Integer>> result = new ArrayList<>();
        q.add(root);
        if(root==null)return result;
        while(!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i=0;i<levelNum;i++){
                TreeNode temp = q.remove();
                levelList.add(temp.val);
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right); 
            }
            result.add(levelList);
        }
        return result;

    }
}