class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        recursivePartitioning(0, s, result, new ArrayList<>());
        return result;
    }

    static void recursivePartitioning(int ind, String s,  List<List<String>> result, ArrayList<String> tempList){
        if(ind ==s.length()){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=ind;i<s.length();++i){
            if(isValidPalindrome(ind, i, s)){
                tempList.add(s.substring(ind, i+1));
                recursivePartitioning(i+1, s, result, tempList);
                tempList.remove(tempList.size()-1);
            }
        }
    }


    static boolean isValidPalindrome(int start, int end, String str){
        while(start<=end){
            if(str.charAt(start++)!=str.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}