class Solution {
    public int search(int[] nums, int target) {
        //recursive approach
        return searchRecur(nums, 0, nums.length-1, target);
        
    }
    static int searchRecur(int[] nums, int start, int end, int target){
        int mid = (start+end)/2;
        if(start>end)return -1;
        if(nums[mid]==target) return mid;
        else if(target<nums[mid]){
            return searchRecur(nums, start, mid-1, target);
        }
        return searchRecur(nums, mid+1, end, target);
    }


        
        //iterative approach
    //     int start= 0;
    //     int len = nums.length;
    //     int end = len-1;
    //     while(start<=end){
    //         int mid = (start+end)/2;
    //         if(nums[mid]==target)return mid;
    //         else if(nums[mid]<target){
    //             start = mid+1;
    //         }else if(nums[mid]>target){
    //             end = mid-1;
    //         }
    //     }
    // return -1;
}