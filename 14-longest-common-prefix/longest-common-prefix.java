class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        //sorting for common substring is common to all and saves time 
        Arrays.sort(strs);
        String first = strs[0];
        String last =strs[strs.length-1];
        //finding common char between first and last for full coverage since sorted now
        for(int i=0;i<Math.min(first.length(), last.length());i++){
            if(first.charAt(i)!=last.charAt(i)){
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
class Node{
    public Node(){
    }
    Node links[] = new Node[26];
    boolean flag=false;
    boolean containsKey(char ch){
        return (links[ch-'a']!=null);
    }
    void put(char ch, Node node){
        links[ch-'a'] = node;
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    
}
class Test {
    private static Node root;
    public Test(){
        root = new Node();
    }
    public void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.flag=true;
    }
    
    boolean checkIfPrefixExists(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                if(node.flag)return false;
            }
            else{
                return false;
            }
        }
        return true;      
    }

    public String longestCommonPrefix(String[] strs) {
        Node node = root;
        for(int i=0;i<strs.length;i++){
            insert(strs[i]);
        }
        String prefix = "";
        for(int i=0;i<strs.length;i++){
            if(checkIfPrefixExists(strs[i])){
                if(strs[i].length()>=prefix.length()){
                    prefix = strs[i];
                }else if(strs[i].length()==prefix.length() && strs[i].compareTo(prefix)<0){
                    prefix = strs[i];
                }
            }
        }
        return prefix;
    }
}