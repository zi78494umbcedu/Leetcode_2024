/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
public class Solution {
    public static boolean isParentSum(Node root) {
       if(root==null)return true;
        if(root.left==null && root.right==null)return true;
       int child= 0;
       if(root.left!=null)child+=root.left.data;
        if(root.right!=null)child+=root.right.data;
        if(child!=root.data)return false;
        return (isParentSum(root.left)&& isParentSum(root.right));
    }
}
