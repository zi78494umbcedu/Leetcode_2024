import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List< String > generateString(int N) {
        List<String> sol = new ArrayList<String>();
        String s = "";
        generateStringSol(N, sol, s);
        return sol;
    }
    static void generateStringSol(int N, List<String> sol, String str){
        if(str.length()==N){
            sol.add(str);
            return;
        }
        generateStringSol(N, sol, str+"0");
        if(str.length()==0 || str.charAt(str.length()-1)!='1'){
            generateStringSol(N, sol, str+"1");
        }
    }
}



/*
000 - 0
001 - 1
010 - 2
011 - 3 * 
100 - 4
101 - 5
110 - 6 *
111 - 7 *
*/
