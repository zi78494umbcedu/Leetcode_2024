class Solution {
    public int findPeakElement(int[] nums) {
        //edge cases
        if(nums.length==1)return 0;
        if(nums[0]>nums[1])return 0;
        if(nums[nums.length-1]>nums[nums.length-2])return nums.length-1;
        int low = 1;
        int high = nums.length-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])return mid;
            else if(nums[mid]>nums[mid-1])low = mid+1;
            else high=mid-1;
        }
        return -1;
        //brute force
        // for(int i=0;i<nums.length;i++){
        //     if((i==0 || nums[i-1]<nums[i]) && (i==(nums.length-1) || nums[i]>nums[i+1]))
        //     return i;
        // }
        // return -1;
    }
}