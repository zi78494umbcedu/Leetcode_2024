/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        //level order traversal to a string
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp==null){
                str.append("n ");
                continue;
            }
            str.append(temp.val+" "); 
            q.add(temp.left);
            q.add(temp.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")return null;
        //get string of values using the split of "space"
        String[] values = data.split(" ");
        //queue for the level order traversal type deserialisation
        Queue<TreeNode> q = new LinkedList<>();
        //root node to start like in level order
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);        
        for(int i=1;i<values.length;i++){
            TreeNode parent = q.poll();
            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);  
            }
            if(!values[++i].equals("n")){
                TreeNode right =new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);    
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));