class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //recursion
        //initilialising the main returnable list of lists/subsets
        List<List<Integer>> subsets = new ArrayList<>();
        int n  = nums.length-1;
        //calling the recursive function
        recurSubsets(subsets, nums, 0, new ArrayList<>());
        return subsets;
    }
        //bit manipulation method
        // //list of list of integers
        // List<List<Integer>> subs = new ArrayList<>();
        // //iterate over 2^n-1
        // for(int i=0;i<=Math.pow(2, nums.length)-1;i++){
        //     //to store current subset generated
        //     List<Integer> tub = new ArrayList<>();
        //     //checking if jth bit of i is set
        //     for(int j=0;j<=nums.length-1;j++){
        //         if((i&(1<<j))!=0){
        //             tub.add(nums[j]);
        //         }
        //     }
        //     subs.add(tub);
        // } 
        // return subs;

    static void recurSubsets(List<List<Integer>> subsets, int[] nums, int i, List<Integer> tempList){
        if(i==nums.length){
            subsets.add(new ArrayList<>(tempList));
            return;
        }
        tempList.add(nums[i]);
        recurSubsets(subsets, nums, i+1, tempList);
        tempList.remove(tempList.size()-1);
        recurSubsets(subsets, nums, i+1, tempList);
    }
}

/**
2^n-1

0 0 0 
0 0 1
0 1 0 
0 1 1
1 0 0
1 0 1
1 1 0 
1 1 1 

 */