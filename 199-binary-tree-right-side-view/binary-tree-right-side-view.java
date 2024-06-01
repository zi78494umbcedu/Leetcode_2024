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
    public List<Integer> rightSideView(TreeNode root) {
        //root, level number, result ArrayList
        return recursiveRightView(root, 0, new ArrayList<>());
    }
    static List<Integer> recursiveRightView(TreeNode root, int level, List<Integer> rightView){
        if(root==null){
            return rightView;
        }
        if(level==rightView.size()){
            rightView.add(root.val);
        }
        recursiveRightView(root.right, level+1, rightView);
        recursiveRightView(root.left, level+1, rightView);
        return rightView;
    }
}