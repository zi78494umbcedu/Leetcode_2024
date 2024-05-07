class Solution {
    public int myAtoi(String s) {
        
        //if a string is given, then the last character is null by default
        int res = 0;
        int i=0;
        //removing whitespaces from the beginning
        s = s.trim();
        if(s.length()==0)return 0;
        //checking sign of the number
        boolean neg = s.charAt(0)=='-'?true:false;
        if(s.charAt(0)=='+')s=s.substring(1);
        //if sign present then removing the sign and traversing
        if(neg)s = s.substring(1);
        //traversin with the help of a pointer
        while(i<s.length()){
            //getting if digit
            int ch = s.charAt(i)-'0';
            if(ch<=9 && ch>=0){
                //if digit then adding to the built number
                //overflow testcase
                int maxLimit = Integer.MAX_VALUE/10;
                if(res>maxLimit || (ch>7 && res==maxLimit)){
                    return neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
                res = (res*10) + ch;
            }else{
                return neg?-res:res;
            }
            //increment counter for traversal
            i++;
        }
        return neg?-res:res;
    }
}