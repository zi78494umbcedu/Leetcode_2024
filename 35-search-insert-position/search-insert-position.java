class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int start =0;
        int end = len-1;
        
        int ans = len;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target)return mid;
            else if(nums[mid]>=target){
                end = mid-1;
                ans = mid;

            }else{
                start=mid+1;
            }
        }
        return ans;
    }
}