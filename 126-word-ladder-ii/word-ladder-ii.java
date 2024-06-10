class Solution {
    String b;
    HashMap<String,Integer> map=new HashMap<>();
    List<List<String>> ans=new ArrayList<>();
    public void dfs(String end,List<String> seq){
        if(end.equals(b)){
          List<String> list=new ArrayList<>(seq);
          Collections.reverse(list);
          ans.add(list);
          return ;
        }
        String word=end;
        int steps=map.get(word);
        for(int i=0;i<b.length();i++){
            for(char j='a';j<='z';j++){
                char[] helper=word.toCharArray();
                helper[i]=j;
                String str=new String(helper);
                if(map.containsKey(str)&&map.get(str)+1==steps){
                    seq.add(str);
                    dfs(str,seq);
                    seq.remove(seq.size()-1);
                }

            }
        }

    }




    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        b=beginWord;
        HashSet<String> set=new HashSet<>(wordList);
        Queue<String> q=new LinkedList<>();
        map.put(beginWord,1);
        q.add(beginWord);
        set.remove(b);
        while(!q.isEmpty()){
            String word=q.poll();
           int step=map.get(word);
           if(word==endWord){
               break;
           }
           for(int i=0;i<b.length();i++){
               for(char j='a';j<='z';j++){
                   char[] helper=word.toCharArray();
                   helper[i]=j;
                   String str=new String(helper);
                   if(set.contains(str)){
                       q.add(str);
                       map.put(str,step+1);
                       set.remove(str);
                   }
               }
           }
        }
        if(map.containsKey(endWord)){
            List<String> solver=new ArrayList<>();
            solver.add(endWord);
            dfs(endWord,solver);

        }

        return ans;
    }
}

        // Set<String> set = new HashSet<>();
        // for(String word:wordList){
        //     set.add(word);
        // }
        // List<List<String>> result = new ArrayList<>();
        // if(!set.contains(endWord))return result;
        // Queue<List<String>> q=  new LinkedList<>();
        // List<String> sequence = new ArrayList<>();
        // sequence.add(beginWord);
        // q.add(sequence);
        // List<String> usedOnLevel = new ArrayList<>();
        // usedOnLevel.add(beginWord);
        // int level=0;
        // while(!q.isEmpty()){
        //     List<String> temp = q.poll();
        //     if(temp.size()>level){
        //         level++;
        //         for(String word:usedOnLevel){
        //             set.remove(word);
        //         }
        //     }
        //     String lastWord = temp.get(temp.size()-1);
        //     if(lastWord.equals(endWord)){
        //         if(result.size()==0){
        //             result.add(temp);
        //         }else if(temp.size()==result.get(0).size()){
        //             result.add(temp);
        //         }
        //     }
        //     for(int i=0;i<lastWord.length();i++){
        //         for(char c='a';c<='z';c++){
        //             char[] charArray = lastWord.toCharArray();
        //             charArray[i]=c;
        //             String newWord = new String(charArray);
        //             if(set.contains(newWord)){
        //                 temp.add(newWord);
        //                 List<String> updatedSequence = new ArrayList<>(temp);
        //                 q.add(updatedSequence);
        //                 usedOnLevel.add(newWord);
        //                 temp.remove(temp.size()-1);
        //             }
        //         }
        //     }
        // }
        // return result;
    
