class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        //to make the duplicates together since our logic of looping through the array is dependent
        Arrays.sort(nums);
        recurCallToPower(0, nums, powerSet, new ArrayList<>());
        return powerSet;
    }
    //reducing time from 2^n*k*logn by some factor by looping over the array to avoid duplicate arrays which the sort and hashset is helping remove but adding complexty
    static void recurCallToPower(int ind, int[] nums, List<List<Integer>> subsets, List<Integer> tempList){
        subsets.add(new ArrayList<>(tempList));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1])continue;
            tempList.add(nums[i]);
            recurCallToPower(i+1, nums, subsets, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}