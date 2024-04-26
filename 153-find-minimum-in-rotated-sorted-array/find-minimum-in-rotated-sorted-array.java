class Solution {
    public int findMin(int[] nums) {
        int low =0;
        int len = nums.length;
        int high = len-1;
        int min = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low]<=nums[high]){
                min = Math.min(nums[low], min);
                break;
            }
            //sorted half may or may not have the minimum element
            if(nums[low]<=nums[mid]){
                min = Math.min(min, nums[low]);
                low = mid+1;
            }else if(nums[mid]<=nums[high]){
                min = Math.min(min,nums[mid]);
                high = mid-1;
            }
        }
        return min;
    }
}