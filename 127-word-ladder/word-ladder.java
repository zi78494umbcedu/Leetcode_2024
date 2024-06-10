class Pair{
    String first;
    int second;
    
    public Pair(String first, int second){
        this.first= first;
        this.second= second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //brute force, replacing each character in word from A-Z 
        //checking in the hashset and maintaining steps
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        
        while(!q.isEmpty()){
            Pair temp=q.poll();
            String tempWord= temp.first;
            int steps = temp.second;
            
            if(tempWord.equals(endWord)){
                return steps;
            }
            for(int i=0;i<tempWord.length();i++){
                char[] charArrayOld=tempWord.toCharArray();
                for(char c = 'a';c<='z';c++){
                    charArrayOld[i]=c;
                    String newWord = new String(charArrayOld);
                    if(set.contains(newWord)){
                        q.add(new Pair(newWord, steps+1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}