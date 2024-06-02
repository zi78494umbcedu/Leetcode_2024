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
 class Pair{
    TreeNode node;
    int index;
    public Pair(TreeNode node, Integer index){
        this.node = node;
        this.index = index;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        //level order
        //List<List<Integer>> list = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        if(root==null)return 0;
        int width=1;
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int min_index = q.peek().index;
            int first=0;
            int last = 0;
            //List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                int curr_index = q.peek().index-min_index;
                TreeNode tempNode = q.poll().node;
                if(i==0)first=curr_index;
                if(i==size-1)last = curr_index;
                //temp.add(tempNode.val);
                if(tempNode.left!=null)q.add(new Pair(tempNode.left,2*curr_index+1));
                if(tempNode.right!=null)q.add(new Pair(tempNode.right, 2*curr_index+2));
            }
            width = Math.max(width, last-first+1);
            //list.add(temp);
        }
        //System.out.println(list);
        return width;
    }
}