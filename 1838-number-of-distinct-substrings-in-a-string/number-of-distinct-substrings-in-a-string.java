class Node{
    Node links[] = new Node[26];

    boolean containsKey(char ch){
        return (links[ch-'a']!=null);
    }

    void put(char ch, Node node){
        links[ch-'a'] = node;
    }

    Node get(char ch){
        return links[ch -'a'];
    }


}
class Solution {
    private static Node root;
    public Solution(){
        root = new Node();
    }

    static int insertSub(String s, int dist){
        Node node =root;
        for(int i=0;i<s.length();i++){
            if(!node.containsKey(s.charAt(i))){
                node.put(s.charAt(i), new Node());
                dist++;
            }
            node = node.get(s.charAt(i));
        }
        return dist;
    }
    
    public int countDistinct(String s) {
        Node node = root;
        int dist= 0;
        for(int i=0;i<s.length();i++){
            dist = insertSub(s.substring(i, s.length()), dist);
        }
        return dist;
    }
}