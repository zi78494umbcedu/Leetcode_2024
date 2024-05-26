class Solution {
    public int removeDuplicates(int[] nums) {
        //pointer @ 0
        int initial=0;
        for(int i=1;i<nums.length;i++){
            if(nums[initial]!=nums[i]){
                nums[initial+1] = nums[i];
                initial++;
            }
        }
        return initial+1;
    }
}