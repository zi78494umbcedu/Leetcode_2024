/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     BinaryTreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/
class NodeValue{
    public int minNode, maxNode, maxSize;
    public NodeValue(int minNode, int maxNode, int maxSize){
        this.minNode=minNode;
        this.maxNode = maxNode;
        this.maxSize=maxSize;
    }
}
public class Solution {
    private static NodeValue largestBSTHelper(TreeNode root){
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        //post order since have to find 
        //max of left to be smallest
        //min of right to be largest 
        //than the root => left, right, root
        NodeValue left = largestBSTHelper(root.left);
        NodeValue right = largestBSTHelper(root.right);
        //root comparison for BST
        if(left.maxNode<root.data && root.data<right.minNode){
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode), 1+left.maxSize+right.maxSize);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }  
    public static int largestBST(TreeNode root) {
        return largestBSTHelper(root).maxSize;
    }
}
