import java.util.HashMap;

public class Solution {
    public static int getLongestZeroSumSubarrayLength(int []arr){
        //better approach using hashmap
        int maxLen =0;
        int n=arr.length;
        int sum=0;
        //sum, index
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            //if sum is seen before
            if(map.containsKey(sum)){
                int len = i-map.get(sum);
                maxLen = Math.max(len, maxLen);
            }else{
                map.put(sum, i);
            }
        }
        
        return maxLen;
        //brute force - n^2
        // int maxLen =0;
        // int n=arr.length;
        // for(int i=0;i<n;i++){
        //     int sum=arr[i];
        //     if(sum==0){
        //         maxLen = Math.max(maxLen, 1);
        //     }
        //     for(int j=i+1;j<n;j++){
        //         sum+=arr[j];
        //         if(sum==0){
        //             maxLen = Math.max(maxLen, j-i+1);
        //         }
                
        //     }
        // }
        // return maxLen;
    }
}
