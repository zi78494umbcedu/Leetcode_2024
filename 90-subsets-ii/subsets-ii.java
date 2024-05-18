class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        Arrays.sort(nums);
        recurCallToPower(0, nums, powerSet, new ArrayList<>());
        return powerSet;
    }
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