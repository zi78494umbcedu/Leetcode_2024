class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==1 || nums.length==0)return;
        int nonZeroIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[nonZeroIndex] = nums[i];
                //makes index +1 in the final case
                nonZeroIndex++;
            }
        }
        while(nonZeroIndex<nums.length){
            //zero can be placed non Zero Index directly
            nums[nonZeroIndex] =0;
            nonZeroIndex++;
        }

    }
}