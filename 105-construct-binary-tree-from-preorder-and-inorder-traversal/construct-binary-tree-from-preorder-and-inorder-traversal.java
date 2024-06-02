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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //return root
        //preorder = root, left, right
        //inorder = left, root, right
        //putting inorder in hashmap to the root in the inorder
        Map<Integer, Integer> mapInorder = new HashMap<>();
        int inorderLen = inorder.length;
        for(int i=0;i<inorderLen;i++){
            mapInorder.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, mapInorder);
        return root;
    }

    static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> mapInorder){
        if(preStart>preEnd || inStart>inEnd)return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex= mapInorder.get(root.val);
        int numsLeft= inIndex-inStart;
        root.left = buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inIndex-1, mapInorder);
        root.right = buildTree(preorder, preStart+numsLeft+1, preEnd, inorder, inIndex+1, inEnd, mapInorder);
        return root;
    }
}