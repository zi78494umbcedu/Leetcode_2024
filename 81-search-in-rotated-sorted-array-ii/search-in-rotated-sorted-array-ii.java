class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target)return true;
            //same mid and low and high
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low +=1;;
                high-=1;;
                continue;
            }
            //left array is sorted
            else if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<=nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }//if right array is sorted
            else{
                if(nums[mid]<=target && target<=nums[high]){
                    low =mid+1;
                }else{
                    high = mid-1;
                }

            }
        }
        return false;
    }
}