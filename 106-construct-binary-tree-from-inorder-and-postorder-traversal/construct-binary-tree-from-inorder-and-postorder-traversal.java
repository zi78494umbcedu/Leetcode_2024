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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> mapInorder = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mapInorder.put(inorder[i],i);
        }
        TreeNode root =buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, mapInorder);
        return root;
    }
    static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inorderMap){
        if(inStart>inEnd || postStart>postEnd)return null;
        TreeNode root =new TreeNode(postorder[postEnd]);
        int inIndex = inorderMap.get(root.val);
        int numsleft = inIndex-inStart;
        root.left = buildTree(inorder, inStart, inIndex-1, postorder, postStart, postStart+numsleft-1, inorderMap);
        root.right = buildTree(inorder, inIndex+1, inEnd, postorder, postStart+numsleft, postEnd-1, inorderMap);
        return root;
    }
}
//0,1,2,3,4