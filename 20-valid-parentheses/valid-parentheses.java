class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            System.out.println(s.charAt(i));
            //if finding opening braces, add to stack
            if(s.charAt(i)=='('|| s.charAt(i)=='[' || s.charAt(i)=='{'){
                st.add(s.charAt(i));
            }
            else{
                //if closing braces found, and no matching opening braces found
                if(st.empty())return false;
                //if closing braces found and stack not empty, check for latest stack for matching
                char c = st.peek();
                st.pop();
                if((s.charAt(i)==')' && c =='(') || (s.charAt(i)==']' && c=='[')  || (s.charAt(i)=='}' && c=='{')){
                   
                    System.out.println("Reaching here");;
                }else{
                    return false;
                }
            }
        }
        if(st.empty()){
            return true;
        }
        return false;

    }
}