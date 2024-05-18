class Solution {
    final char[][] L = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        //length of the string e.g., abc => 3 
        int len = digits.length();
        //result combination list
        List<String> combinations = new ArrayList<>();
        //edge case when empty string "" given when no number dialed
        if(len==0)return combinations;
        recurCallForCombination(0, len, digits, combinations, new StringBuilder());
        return combinations;
    }

    void recurCallForCombination(int pos, int len, String digits, List<String> combinations, StringBuilder str){
        if(pos==len){
            combinations.add(str.toString());
        }
        else{
            //getting letters of the number at the position in the given string
            //digits.charAt(pos) => gives the character at that position in the given string
            //char getNumericValue gives the number 
            char[] letters = L[Character.getNumericValue(digits.charAt(pos))];
            for(int i=0;i<letters.length;i++){
                recurCallForCombination(pos+1, len, digits, combinations, new StringBuilder(str).append(letters[i]));
            }
        }
    }
}