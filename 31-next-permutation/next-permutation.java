class Solution {
    public void nextPermutation(int[] nums) {
        //find dip index of the end possible rise(if no dip found then reverse and return since the last permutation it is)
        //find next closest element for the left of the rise for next nextPermutation
        //sort remaining elements on the right of the dip
        int index=-1;
        int n=nums.length;
        //step1
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        //edge case
        
        if(index==-1){
            reverse(nums, 0, n-1);
            return;
        }
        //step2
        for(int i=n-1;i>index;i--){
            if(nums[i]>nums[index]){
                //swap the index rise with the next slightest biggest 
                int temp= nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        //step3
        reverse(nums, index+1, n-1);
    }
    static void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;;
        }
    }
}