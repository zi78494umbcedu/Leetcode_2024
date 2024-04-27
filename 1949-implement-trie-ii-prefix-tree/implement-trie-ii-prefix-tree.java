class Node{
    Node[] links = new Node[26];
    int endsWith = 0;
    int cntPrefix =0;

    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    void put(char ch, Node node){
        links[ch-'a'] = node;
    }

    Node get(char ch){
        return links[ch-'a'];
    }


}

class Trie {
    public static Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.cntPrefix++;
        }
        node.endsWith++;
    }
    
    public int countWordsEqualTo(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            else{
                node = node.get(word.charAt(i));
            }
        }
        return node.endsWith;
    }
    
    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return 0;
            }
            else{
                node = node.get(prefix.charAt(i));
            }
        }
        return node.cntPrefix;
    }
    
    public void erase(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return;
            }
            else{
                node = node.get(word.charAt(i));
                node.cntPrefix--;
            }
        }
        node.endsWith--;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */