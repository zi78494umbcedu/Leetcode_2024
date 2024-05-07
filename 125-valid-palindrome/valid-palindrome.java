class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]","");
        return checkPalin(0, s);
    }
    static boolean checkPalin(int i, String s){
        if(i>=(s.length()/2)){
            return true;
        }
        if(s.charAt(i)!=s.charAt(s.length()-1-i)){
            return false;
        }
        return checkPalin(i+1, s);
    }
}