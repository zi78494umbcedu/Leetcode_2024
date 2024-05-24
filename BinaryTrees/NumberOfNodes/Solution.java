public class Solution {
    public static int numberOfNodes(int N){
        //2^n-1
        //System.out.println(N-1);
        return 1<<(N-1);
    }
}
