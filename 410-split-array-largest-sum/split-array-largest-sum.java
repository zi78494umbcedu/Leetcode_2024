class Solution {
    public int splitArray(int[] nums, int k) {
        int low = getMax(nums);
        int high = getSum(nums);
        while(low<=high){
            int mid = (low+high)/2;
            if(getArraySplits(nums, mid)<=k){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    static int getArraySplits(int[] nums, int sum){
        int arraySize = 1;
        int maxSum = 0;
        for(int i=0;i<nums.length;i++){
            if(maxSum+nums[i]<=sum){
                maxSum+=nums[i];
            }else{
                arraySize++;
                maxSum = nums[i];
            }
        }
        return arraySize;
    }

    static int getMax(int[] nums){
        int maxx = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            maxx = maxx>nums[i]?maxx:nums[i];
        }
        return maxx;
    }

    static int getSum(int[] nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return sum;
    }
}