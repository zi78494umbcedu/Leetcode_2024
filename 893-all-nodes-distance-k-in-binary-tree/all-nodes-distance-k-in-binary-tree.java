/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class Pair{
    TreeNode node;
    TreeNode parent;
    public Pair(TreeNode node, TreeNode parent){
        this.node =node;
        this.parent = parent;
    }
 }
class Solution {

    static void markParents(Map<TreeNode, TreeNode> parentsMap, TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left!=null){
                parentsMap.put(temp.left, temp);
                q.add(temp.left);
            }
            if(temp.right!=null){
                parentsMap.put(temp.right, temp);
                q.add(temp.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(parentMap, root);
        List<Integer> result = new ArrayList<>();
        //2 data structures, 1 queue to traverse, visited map
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        //starting from target
        q.add(target);
        visited.put(target, true);
        //keep track of distance from target
        int curr_level=0;
        //2nd BFS to go the K distance from target, using the visited hashMap
        while(!q.isEmpty()){
            int size = q.size();
            if(curr_level==k)break;
            curr_level++;
            for(int i=0;i<size;i++){
                TreeNode current = q.poll();
                if(current.left!=null && visited.get(current.left)==null){
                    q.add(current.left);
                    visited.put(current.left, true);
                }
                if(current.right!=null && visited.get(current.right)==null){
                    q.add(current.right);
                    visited.put(current.right, true);
                }
                if(parentMap.get(current)!=null && visited.get(parentMap.get(current))==null){
                    q.add(parentMap.get(current));
                    visited.put(parentMap.get(current), true);
                }
            }
        }
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            result.add(temp.val);
        }
        return result;
    }
}