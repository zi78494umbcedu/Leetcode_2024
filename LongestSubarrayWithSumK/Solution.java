import java.util.*;


public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        //2-pointer approach
        int maxLen = 0;
        long sum=a[0];
       int left=0;
       int right =0;
       int n=a.length;
       while(right<n){
           //remove elements from left 
           while(left<=right && sum>k){
               sum-=a[left];
               left++;
           }
           //found subarray of sum k
           if(sum==k)maxLen = Math.max(maxLen, right-left+1);
           //adding to sum while careful about the edge
           right++;
           if(right<n){
               sum+=a[right];
           }
        }
        return maxLen;
        //hashing
        // HashMap<Long, Integer> map = new HashMap<>();
        // int len = 0;
        // int maxLen=0;
        // long sum=0;
        // for(int i=0;i<a.length;i++){
        //     sum+=a[i];
        //     if(sum==k){
        //         maxLen = Math.max(maxLen, i+1);
        //     }
        //     //remaining sum
        //     long remainingSum = sum-k;
        //     //find the new len and update maxLen
        //     if(map.containsKey(remainingSum)){
        //         //forward length of the new subarray found
        //         len = i-map.get(remainingSum);
        //         maxLen = Math.max(len, maxLen);
        //     }
        //     //updating map with sum 
        //     if(!map.containsKey(sum)){
        //         map.put(sum, i);
        //     }
        // }
        // return maxLen;
        //approach 2 O(n^2)
        // int len=0;
        // for(int i=0;i<a.length;i++){
        //     long sum=0;
        //     for(int j=i;j<a.length;j++){
        //         sum+=a[j];
        //         if(sum==k)len=Math.max(len, j-i+1);
        //     }
        // }
        // return len;
        // Brute force approach O(n^3)
        // int len=0;
        // for(int i=0;i<a.length;i++){
        //     for(int j=0;j<a.length;j++){
        //         long sum=0;
        //         for(int m=i;m<=j;m++){
        //             sum+=a[m];
        //         }
        //         if(sum==k)len=Math.max(len, j-i+1);
        //     }
        // }
        // return len;
    }
}
