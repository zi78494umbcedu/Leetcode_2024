class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //bit manipulation method
        //looping across the number of subsets => 2^-1
        int n = nums.length;
        List<List<Integer>> subsets = new ArrayList<>();
        for(int i=0;i<(1<<n);i++){
            //initialising internal subset space
            List<Integer> sub = new ArrayList<>();
            //looping through the length of the Array
            for(int j=0;j<n;j++){
                //checking if the bit is set for populating the integer in the place
                if((i&(1<<j))!=0){
                    sub.add(nums[j]);
                }
            }
            subsets.add(sub);
        } 
        return subsets;
    }
}