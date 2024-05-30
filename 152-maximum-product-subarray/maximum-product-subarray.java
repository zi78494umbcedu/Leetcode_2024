class Solution {
    public int maxProduct(int[] nums) {
        //Observations
        //all positive elements - multiply all 
        //even number of negative elements - multiply all
        //odd number of negative elements - remove one negative and the remaining subarray -> prefix/suffix
        //has zeroes
        int maxProd = Integer.MIN_VALUE;
        int n = nums.length;
        //prefix + suffix 
        int prefix=1;
        int suffix=1;
        for(int i=0;i<n;i++){
            if(prefix==0)prefix=1;
            if(suffix==0)suffix=1;
            prefix*=nums[i];
            maxProd = Math.max(prefix, maxProd);
            suffix*=nums[n-1-i];
            maxProd = Math.max(suffix, maxProd);   
        }
        return maxProd;
        //brute force n^2
        // int maxProd = Integer.MIN_VALUE;
        // int n=nums.length;
        // if(n==1)return nums[0];
        // //brute force
        // for(int i=0;i<n;i++){
        //     int prod=nums[i];
        //     maxProd = Math.max(prod, maxProd);
        //     for(int j=i+1;j<n;j++){
        //         prod *=nums[j];
        //         maxProd = Math.max(prod, maxProd);
        //     }
            
        // }
        // return maxProd;
    }
}