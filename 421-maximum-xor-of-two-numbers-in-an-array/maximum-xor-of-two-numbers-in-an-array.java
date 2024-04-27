class Node{
    Node[] links = new Node[2];
    

    public Node(){

    }
    boolean containsKey(int k){
        return (links[k]!=null);
    }

    void put(int k, Node node){
        links[k] = node;
    }

    Node get(int k){
        return links[k];
    }

    void insert(int n, Node root){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = (n>>i) &1;
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }
    int getMax(int n, Node root){
        Node node = root;
        int max=0;
        for(int i=31;i>=0;i--){
            int bit = (n>>i)&1;
            if(node.containsKey(1-bit)){
                max = max | (1<<i);
                node = node.get(1-bit);
            }else{
                node = node.get(bit);
            }
        }
    return max;
    }
}


class Solution {
    public static Node root;
    public Solution(){
        root = new Node();
    }

    public int findMaximumXOR(int[] nums) {
        for(int i=0;i<nums.length;i++){
            root.insert(nums[i], root);
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, root.getMax(nums[i], root));
        }
        return max;
    }
}