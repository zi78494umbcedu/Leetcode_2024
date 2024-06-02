/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    static List<TreeNode> recursivePath(TreeNode root, TreeNode p, List<TreeNode> path){
        if(root==null)return new ArrayList<>();
        path.add(root);
        if(root==p){
            return new ArrayList<>(path);
        }
        List<TreeNode> leftPath = new ArrayList<>();
         List<TreeNode> rightPath = new ArrayList<>();
        if(root.left!=null){
            leftPath = recursivePath(root.left, p, new ArrayList<>(path));
            if(!leftPath.isEmpty() && leftPath.get(leftPath.size()-1)==p){
                return leftPath;
            }
        }
        if(root.right!=null){
            rightPath = recursivePath(root.right, p,  new ArrayList<>(path));
            if(!rightPath.isEmpty() && rightPath.get(rightPath.size()-1)==p){
                return rightPath;
            }
        }
        return new ArrayList<>();
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case 
        if(root==null || root==p || root==q){
            return root;
        }
        //traveral
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //result
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }
        else{
            return root;
        }
        //brute force
        // if(root==null || p==null || q==null)return null;
        // List<TreeNode> path1 = recursivePath(root, p, new ArrayList<>());
        // List<TreeNode> path2 = recursivePath(root, q, new ArrayList<>());
        // int i=0;
        // while(i<path1.size() && i<path2.size() && path1.get(i)==path2.get(i)){
        //     i++;
        // }
        // return path1.get(i-1);
    }
}