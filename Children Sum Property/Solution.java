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

    static void makingValidChildrenSumProperty(Node root){
        if(root==null){
            return;
        }
        int child=0;
        if(root.left!=null){
            child+=root.left.data;
        }
        if(root.right!=null){
            child+=root.right.data;
        }
        //if child value is greater than the parent.,parent =left+right
        if(child>=root.data){
            root.data = child;
        }else{
            //if child<parent then assign children the parent value
            if(root.left!=null){
                root.left.data = root.data;
            }
            if(root.right!=null){   
                root.right.data = root.data;
            }   
        }
        //traversals
        makingValidChildrenSumProperty(root.left);
        makingValidChildrenSumProperty(root.right);
        //adding values from bottom up after replacing the Max(parent, children_sum);
        int total = 0;
        if(root.left!=null){
                total+=root.left.data;
        }
         if(root.right!=null){
                total+=root.right.data;
        }
        //checking if it is not a leaf node, only then we start to rise up
        if(root.left!=null || root.right!=null)root.data=total;
    }
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
