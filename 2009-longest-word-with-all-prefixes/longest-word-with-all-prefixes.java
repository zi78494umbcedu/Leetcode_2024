class Node{
    public static Node root;

  Node[] links = new Node[26];
  boolean flag = false;

  boolean containsKey(char ch){
    return (links[ch-'a']!=null);
  }

  Node get(char ch){
    return links[ch-'a'];
  }

  void put(char ch, Node node){
    links[ch-'a'] = node;
  } 
  static boolean checkIfPrefixExists(String str, Node node){
    for(int i =0;i<str.length();i++){
      if(!node.containsKey(str.charAt(i))){
        return false;
      }
      else{
        node = node.get(str.charAt(i));
        if(!node.flag){
          return false;
        }
      }
    }
    return true;
  }
  static void insert(String str, Node node){
      for(int i=0;i<str.length();i++){
        if(!node.containsKey(str.charAt(i))){
          node.put(str.charAt(i), new Node());
        }
        node = node.get(str.charAt(i));
      }
      node.flag = true;
  }
}
class Solution {
  public static Node root;

  public Solution(){
    root = new Node();
  }
  public String longestWord(String[] words) {
    Node node = new Node();
    String str = "";
    for(int i=0;i<words.length;i++){
      node.insert(words[i], node);
    }
    for(int i=0;i<words.length;i++){
      if(node.checkIfPrefixExists(words[i], node)){
        if(words[i].length()>str.length()){
          str  = words[i];
        }else if(words[i].length()==str.length() && words[i].compareTo(str)<0){
          str  = words[i];
        }
      }
    }
    return str;
  }
}