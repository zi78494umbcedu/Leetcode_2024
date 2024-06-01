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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        //root
        //left boundary
        //leaves
        //right boundary in reverse
        List<Integer> boundary = new ArrayList<>();
        if(root==null) return boundary;
        if(!isLeaf(root))boundary.add(root.val);
        leftBoundary(root, boundary);
        addLeaves(root, boundary);
        rightBoundary(root, boundary);
        return boundary;
    }
    static void rightBoundary(TreeNode root, List<Integer> boundary){
        TreeNode curr = root.right;
        List<Integer> stack = new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr))stack.add(curr.val);
            if(curr.right!=null)curr = curr.right;
            else curr = curr.left;
        }
        for(int i=0;i<stack.size();i++){
            boundary.add(stack.get(stack.size()-1-i));
        }
    }

    static void addLeaves(TreeNode root, List<Integer> boundary){
        if(isLeaf(root)){
            boundary.add(root.val);
            return;
        }
        if(root.left!=null){addLeaves(root.left, boundary);}
        if(root.right!=null){addLeaves(root.right, boundary);}
    }
    static void leftBoundary(TreeNode root, List<Integer> boundary){
        TreeNode curr = root.left;
        while(curr!=null){
            if(!isLeaf(curr))boundary.add(curr.val);
            if(curr.left!=null)curr = curr.left;
            else curr = curr.right;
        }
    }
    static boolean isLeaf(TreeNode node){
        return (node.left==null) && (node.right==null);
    }
}