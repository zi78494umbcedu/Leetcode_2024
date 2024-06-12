class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }
    public int getParent(int node){
        if(node==parent.get(node)){
            return node;
        }
        int interimParent= getParent(parent.get(node));
        parent.set(node, interimParent);
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int parentU = getParent(u);
        int parentV = getParent(v);
        if(parentU==parentV)return;
        int sizeU = size.get(parentU);
        int sizeV = size.get(parentV);
        if(sizeU>sizeV){
            parent.set(parentV, parentU);
            size.set(parentU, sizeU+sizeV);
        }
        else{
            parent.set(parentU, parentV);
            size.set(parentV, sizeU+sizeV);
        }
    }
    public void unionByRank(int u, int v){
         int parentU = getParent(u);
        int parentV = getParent(v);
        if(parentU==parentV)return;
        int rankU = rank.get(parentU);
        int rankV = rank.get(parentV);
        if(rankU>rankV){
            parent.set(parentV, parentU);
        }
        else if(rankU<rankV){
            parent.set(parentU, parentV);
        }else{
            parent.set(parentU, parentV);
            rank.set(parentU, rank.get(parentV)+1);
        }
    }

}    
class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //disjoint set - since union of multiple records with common emails required
        //get parent if not similar, check if contains same emails, then change parent while traversing adj list 
        //emails should be sorted
        //return : name, sorted, merged list of emails
        /**
        1. assign the emails to the nodes indexed 0
        2. make the disjoint set
        3. make the list of merged emails
        4. sort and return the accounts 
        */
        //email, node
        //Step1-> mapping emails to the account node number and making parents
        //email, node-number
        Map<String, Integer> mailNodeMap = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!mailNodeMap.containsKey(email)) {
                    mailNodeMap.put(email, i);
                } else {
                    ds.unionBySize(i, mailNodeMap.get(email));
                }
            }
        }

        // Step 2: Merging name and emails from the disjoint set 
        Map<Integer, List<String>> components = new HashMap<>();
        for (Map.Entry<String, Integer> entry : mailNodeMap.entrySet()) {
            String email = entry.getKey();
            int node = ds.getParent(entry.getValue());
            components.computeIfAbsent(node, k -> new ArrayList<>()).add(email);
        }

        // Step 3: Making final returnable answer, sorted emails list
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : components.entrySet()) {
            int node = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(node).get(0)); // Add the account name
            account.addAll(emails); // Add the sorted emails
            result.add(account);
        }

        return result;
    }
}