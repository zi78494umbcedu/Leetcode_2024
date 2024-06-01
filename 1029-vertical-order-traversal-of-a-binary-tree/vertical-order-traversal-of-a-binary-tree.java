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

 class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode node, Integer row, Integer col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> vertical = new ArrayList<>();
        //row, map<col, values
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        //node, row, col
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            Tuple temp = q.poll();
            TreeNode tempNode = temp.node;
            int row = temp.row;
            int col = temp.col;
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new ArrayList<>());
            map.get(col).get(row).add(tempNode.val);
            if(tempNode.left!=null){
                q.offer(new Tuple(tempNode.left, row+1, col-1));
            }
            if(tempNode.right!=null){
                q.offer(new Tuple(tempNode.right, row+1, col+1));
            }
        }
        for(Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry: map.entrySet()){
            List<Integer> col = new ArrayList<>();
            for(List<Integer> set: entry.getValue().values()){
                Collections.sort(set);
                col.addAll(set);
                //Collections.sort(col);
            }
            vertical.add(col);
        }
        return vertical;
    }
}