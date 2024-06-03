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
    public List<Integer> inorderTraversal(TreeNode root) {
        //Morris's Threaded Traversal
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            //case1 - no left
            if(curr.left==null){
                inorder.add(curr.val); 
                curr =curr.right;
            }
            //case2 - threading if left present., right-most to the root for coming back
            else{
                TreeNode currLeft= curr.left;
                while(currLeft.right!=null && currLeft.right!=curr){
                    currLeft = currLeft.right;
                }
                if(currLeft.right==null){
                    currLeft.right = curr;
                    curr = curr.left;
                }
                else{
                    currLeft.right=null;
                    inorder.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return inorder;
        //iterative method
        // List<Integer> inOrderResult = new ArrayList<>();
        // if(root==null)return inOrderResult;
        // Stack<TreeNode> stack = new Stack<TreeNode>();
        // while(true){
        //     if(root!=null){
        //         stack.add(root);
        //         root=root.left;
        //     }else{
        //         if(stack.isEmpty()){
        //             break;
        //         }
        //         TreeNode temp = stack.pop();
        //         inOrderResult.add(temp.val);
        //         root = temp.right;
        //     }
        // }
        // return inOrderResult;
        //return inOrder(root, new ArrayList<>());
    }
    static List<Integer> inOrder(TreeNode root, List<Integer> traversal){
        if(root==null){
            return traversal;
        }
       
        inOrder(root.left, traversal);
        traversal.add(root.val);
        inOrder(root.right, traversal);
        return traversal;
    }
}