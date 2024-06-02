/********************************************************************

 Following is the class structure of the Node class:

 class BinaryTreeNode {
     int data;
     BinaryTreeNode left;
     BinaryTreeNode right;

     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 };

 ********************************************************************/
import java.util.*;
public class Solution {
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root==null)return paths;
        recursionPaths(root,paths,  "");
        return paths;
    }
    static void recursionPaths(BinaryTreeNode root, List<String> paths, String str){
        if(root!=null){
           str+=Integer.toString(root.data);
        }
        if(root.left==null && root.right==null){
            paths.add(str);
        }else{
            if(root.left!=null){
                recursionPaths(root.left, paths, str+" ");
            }
             if(root.right!=null){
                recursionPaths(root.right, paths, str+" ");
            }
        }
    }
}
