class Solution {
    public int maxSubArray(int[] nums) {
        //optimal approach O(n) Kadane's Algorithm
        int start=0;
        int sum=0;
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        int startIndex=0;
        int endIndex=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum>maxSum){
                maxSum=sum;
                endIndex=i;
            }
            if(sum<0){
                sum=0;
            }
            if(sum==0){
                startIndex=i;
            }
        }
        return maxSum;

        //brute force O(n^2)
        // int maxSum=Integer.MIN_VALUE;
        // int n = nums.length;
        // for(int i=0;i<n;i++){
        //     int sum=0;
        //     for(int j=i;j<n;j++){
        //         sum+=nums[j];
        //         maxSum = Math.max(maxSum, sum);
        //     }
            
        // }
        // return maxSum;  
    }
}