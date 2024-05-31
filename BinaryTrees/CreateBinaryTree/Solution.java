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
    
    public static Node createTree(int []arr){
        if(arr==null || arr.length==0){
            return null;
        }
        return createTree(arr, 0);
    }
    static Node createTree(int[] arr, int indx){
        if(indx>=arr.length){
            return null;
        }
        //create new node with ith current element
        //main return logic building bottom-up
        Node root = new Node(arr[indx]);
        //subtree on the left child
        //starting index is 0 and not 1
        root.left = createTree(arr, 2*indx+1);
        //subtree on the right child
         //starting index is 0 and not 1
        root.right=createTree(arr, 2*indx+2);
        return root;
    }
}
