class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int low= 1;
        int high = len-2;
        if(len==1)return nums[0];
        if(nums[0]!=nums[1])return nums[0];
        if(nums[len-1]!=nums[len-2])return nums[len-1];
        while(low<=high){
            int mid= (low+high)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1])return nums[mid];
            if((mid%2==0 && nums[mid+1]==nums[mid]) ||(mid%2==1 && nums[mid-1]==nums[mid])){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;


    }
        //brute
    //     int len = nums.length;
    //     if(len==1)return nums[0];
    //     for(int i=0;i<len;i++){
    //         if(i==0){
    //             if(nums[i+1]!=nums[i])return nums[i];
    //         }else if(i==(len-1)){
    //             if(nums[len-1]!=nums[len-2])return nums[len-1];
    //         }
    //         else{
    //             if(nums[i]!=nums[i+1] && nums[i]!=nums[i-1])return nums[i];
    //         }
    //     } 
    //     return 0;
    // }
}