class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //recursive method
        //final answer subsets list of list of integers 
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;
        recurSubsets(nums, n, subsets, 0, new ArrayList<>());
        return subsets;
        // //bit manipulation method
        // //looping across the number of subsets => 2^-1
        // int n = nums.length;
        // List<List<Integer>> subsets = new ArrayList<>();
        // for(int i=0;i<(1<<n);i++){
        //     //initialising internal subset space
        //     List<Integer> sub = new ArrayList<>();
        //     //looping through the length of the Array
        //     for(int j=0;j<n;j++){
        //         //checking if the bit is set for populating the integer in the place
        //         if((i&(1<<j))!=0){
        //             sub.add(nums[j]);
        //         }
        //     }
        //     subsets.add(sub);
        // } 
        // return subsets;
    }

    static void recurSubsets(int[] nums, int n, List<List<Integer>> subsets, int ind, List<Integer> sub){
        if(ind>=n){
            subsets.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[ind]);
        recurSubsets(nums, n, subsets, ind+1, sub);
        sub.remove(sub.size()-1);
        recurSubsets(nums, n, subsets, ind+1, sub);
    }
}