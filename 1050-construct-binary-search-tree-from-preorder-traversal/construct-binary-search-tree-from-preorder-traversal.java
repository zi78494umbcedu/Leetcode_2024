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

    static TreeNode buildRangeTree(int[] preorder, int bound, int[] i){
        if(preorder.length==i[0] || preorder[i[0]]>bound){
            return null;
        }
        TreeNode root =new TreeNode(preorder[i[0]++]);
        root.left = buildRangeTree(preorder, root.val, i);
        root.right = buildRangeTree(preorder, bound, i);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        //Range approach, removing sorting complexity of O(nlogn)
        return buildRangeTree(preorder, Integer.MAX_VALUE, new int[]{0});
    
        //O(nlogn)+O(n), O(n) using preOrder and inorder
        // int[] inorder = preorder.clone();
        // Arrays.sort(inorder);
    
        // Map<Integer, Integer> inorderMap = new HashMap<>();
        // for(int i=0;i<inorder.length;i++){
        //     inorderMap.put(inorder[i], i);
        // }
        // TreeNode root =  buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length, inorderMap);
        // return root;
    }
    static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderMap){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int inIndex = inorderMap.get(root.val);
        int numsleft= inIndex-inStart;
        root.left =buildTree(preorder, preStart+1, preStart+numsleft, inorder, inStart, inIndex-1, inorderMap);
        root.right=buildTree(preorder, preStart+numsleft+1, preEnd, inorder, inIndex+1, inEnd, inorderMap);
        return root;
    }
}