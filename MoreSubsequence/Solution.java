import java.util.*;

public class Solution {
    public static String moreSubsequence(int n, int m, String a, String b) {
        List<List<String>> aSubs = new ArrayList<>();
        List<List<String>> bSubs = new ArrayList<>();
        recurSubsets(a, 0, aSubs, new ArrayList<>());
        recurSubsets(b, 0, bSubs, new ArrayList<>());
        //System.out.println(aSubs.size()+"/"+bSubs.size());
        if(aSubs.size()>=bSubs.size())return a;
        else{
            if(n>m)return b;
        }
        return b;
    }

    static void recurSubsets(String str, int i, List<List<String>> subsets, List<String> tempList){
        if(i==str.length()){
            subsets.add(new ArrayList<>(tempList));
            return;
        }
        if(!tempList.contains(String.valueOf(str.charAt(i)))){
             tempList.add(String.valueOf(str.charAt(i)));
            recurSubsets(str, i+1, subsets, tempList);
            tempList.remove(tempList.size()-1);
        }
        recurSubsets(str, i+1, subsets, tempList);
    }
}
