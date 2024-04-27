class Node{
    Node[] links = new Node[2];

    boolean containsKey(int n){
        return (links[n]!=null);
    }
    void put(int n, Node node){
        links[n] = node;
    }
    Node get(int n){
        return links[n];
    }
}
class Trie{
    public static Node root;
    public Trie(){
        root = new Node();
    }
    public void insert(int n){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = (n>>i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }
    public int getMax(int n){
        Node node = root;
        int max=0;
        for(int i =31;i>=0;i--){
            int bit = (n>>i)&1;
            if(node.containsKey(1-bit)){
                max = max | (1<<i);
                node = node.get(1-bit);
            }
            else{
                node = node.get(bit);
            }
        }
        return max;
    }
}
class Solution {
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<ArrayList<Integer>>();
        int m = queries.length;
        for(int i=0;i<m;i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(queries[i][1]);
            temp.add(queries[i][0]);
            temp.add(i);
            offlineQueries.add(temp);
        }
        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                return a.get(0).compareTo(b.get(0));
            }
        });
        int ind=0;
        int n = nums.length;
        Trie trie = new Trie();
        int[] answer = new int[m];
        for(int i=0;i<m;i++){answer[i] = -1;}
        // Sort nums array for binary search
        Arrays.sort(nums);

        for(int i=0;i<m;i++){
            while(ind<n && nums[ind] <=offlineQueries.get(i).get(0)){
                trie.insert(nums[ind]);
                ind++;
            }
            int queryInd=offlineQueries.get(i).get(2);
            if (trie.root.containsKey(0) || trie.root.containsKey(1)) {
                // If there are elements in nums <= offlineQueries.get(i).get(0)
                answer[queryInd] = trie.getMax(offlineQueries.get(i).get(1));
            } else {
                // If there are no elements in nums <= offlineQueries.get(i).get(0)
                answer[queryInd] = -1;
            }
        }
        return answer;
    }
}