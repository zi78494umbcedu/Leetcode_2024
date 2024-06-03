public class Solution {
    public static boolean isValidBST(int []order){
        for(int i=0;i<order.length-1;i++){
            if(order[i]>=order[i+1]){
                return false;
            }
        }
        return true;
    }
}
