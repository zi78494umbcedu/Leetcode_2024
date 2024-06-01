/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.*;

import javax.lang.model.element.Element;
class Pair{
    TreeNode node;
    int counter;
    Pair(TreeNode node, Integer counter){
        this.counter=counter;
        this.node = node;
    }
}
public class Solution {

    static List<Integer> preOrderTraversal(TreeNode root, List<Integer> temp){
        if(root==null){
            return temp;
        }
        temp.add(root.data);
        preOrderTraversal(root.left, temp);
        preOrderTraversal(root.right, temp);
        return temp;
    }
    static List<Integer> inOrderTraversal(TreeNode root, List<Integer> temp){
        if(root==null){
            return temp;
        }
        inOrderTraversal(root.left, temp);
        temp.add(root.data);
        inOrderTraversal(root.right, temp);
        return temp;
    }
    static List<Integer> postOrderTraversal(TreeNode root, List<Integer> temp){
        if(root==null){
            return temp;
        }
        postOrderTraversal(root.left, temp);
        postOrderTraversal(root.right, temp);
        temp.add(root.data);
        return temp;
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        //in single flow
        //stack with node, number
        //if number is 1 then add to preOrder since root and add number by 1 and add left is !=null 
        //if number is 2 then add to inOrder since that would be the left and increment number and add right if !=null
        //if number is 3 then add to postOrder
        List<List<Integer>> traversals= new ArrayList<>();
        List<Integer> preOrder= new ArrayList<>();
        List<Integer> inOrder= new ArrayList<>();
        List<Integer> postOrder= new ArrayList<>();
        Stack<Pair> stack = new Stack<Pair>();
        if(root==null)return traversals;
        Pair node =new Pair(root, 1);
        stack.add(node);
        while(!stack.isEmpty()){
            Pair element = stack.peek();
            if(element.counter==1){
                preOrder.add(element.node.data);
                element.counter++;
                if(element.node.left!=null){
                    Pair left = new Pair(element.node.left, 1);
                    stack.add(left);
                }
            }else if(element.counter==2){
                inOrder.add(element.node.data);
                element.counter++;
                if(element.node.right!=null){
                    Pair right = new Pair(element.node.right, 1);
                    stack.add(right);
                }
            }else if(element.counter==3){
                postOrder.add(element.node.data);
                stack.pop();
            }
        }
       
        traversals.add(inOrder);
        traversals.add(preOrder);
        traversals.add(postOrder);
        return traversals;

        // List<List<Integer>> traversals = new ArrayList<>();
        // if(root==null)return traversals;
        // traversals.add(inOrderTraversal(root, new ArrayList<>()));
        // traversals.add(preOrderTraversal(root, new ArrayList<>()));
        // traversals.add(postOrderTraversal(root, new ArrayList<>()));
        // return traversals;
    }
}
