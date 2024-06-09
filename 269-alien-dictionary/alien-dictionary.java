

import static java.lang.System.in;

class Solution {
    public String alienOrder(String[] words) {
        //conditions for correct dictionary
        //1.cyclic - adb, bdc, aba
        //2.adb, ab, larger string is before smaller string
        //Steps
        //making the adjacency graph 
        //finding topo sorting alienOrder(toString())

        //initialisation of adjacency and indegree
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(String word:words){
            for(char c:word.toCharArray()){
                adj.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }
       //building graph by comparing the strings
        for(int i=0;i<words.length-1;i++){
            String str1= words[i];
            String str2 =words[i+1];
            //edge case of type 2: adcd, abc -> illegal dict, with longerr words before shorter ones
           if(str1.length()>str2.length() && str1.startsWith(str2)){
            return "";
           }
            int len = Math.min(str1.length(), str2.length());
            for(int ptr=0;ptr<len;ptr++){
                if(str1.charAt(ptr)!=str2.charAt(ptr)){
                    adj.get(str1.charAt(ptr)).add(str2.charAt(ptr));
                    indegree.put(str2.charAt(ptr), indegree.get(str2.charAt(ptr))+1);
                    break;
                }
            }
        }
        //kahn's algorithm to find the topo sort
        //adj done
        //indegree done
        //adding terminals to queue
        Queue<Character> q =new LinkedList<>();
        for(char c:indegree.keySet()){
            if(indegree.get(c)==0){
                q.add(c);
            }
        }
        //breadth first search
        StringBuilder order =new StringBuilder();
        while(!q.isEmpty()){
            Character temp = q.poll();
            order.append(temp);
            for(char neighbour:adj.get(temp)){
                indegree.put(neighbour, indegree.get(neighbour)-1);
                if(indegree.get(neighbour)==0){
                    q.add(neighbour);
                }
            }
        }
        //edge case type 1: covered if cycle -> no topographical sorted order found for all elements
        if(order.toString().length()!=adj.size())return "";
        return order.toString();
        
    }
    static List<Integer> topoSort(int n, List<List<Integer>> adj){
        //indegree from adjacency
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            for(int neighbour:adj.get(i)){
                indegree[neighbour]++;
            }
        }
        //adding terminals to queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        //breadth first traversal
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int temp = q.poll();
            topo.add(temp);
            for(int neighbour:adj.get(temp)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        return topo;
    }
}