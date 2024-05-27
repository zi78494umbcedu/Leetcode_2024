class Solution {
    public void rotate(int[] nums, int k) {
        //optimal approach to in place space
        k=k%nums.length;
        reverse(0, nums.length-1, nums);
        reverse(0, k-1, nums);
        reverse(k, nums.length-1, nums);
        //brute force
        // //first step - making k in length of the array
        // k=k%nums.length;
        // int[] temp = new int[k];
        // for(int i=0;i<k;i++){
        //     temp[i]= nums[i];
        // }
        ////shifting left the rest elements 
        //for(int j=k;j<nums.length;j++){
        //   nums[j-k] = nums[j];
        //}  
        ////adding remaining elements in the end 
        //for(int j=0;j<temp.length;j++){   
        //  nums[nums.length-k+j]=temp[j]; 
        //}
    }
    static void reverse(int start, int end, int[] array){
        while(start<end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}