class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len =nums.length;
        //number of permutations is len!; || 3!=6
        //if(len==1)return new ArrayList<>(nums[0]);
        List<List<Integer>> combinations = new ArrayList<>();
        recurPermutations(0, nums, len, combinations, new ArrayList<>());
        return combinations;
    }
    
    //looping over the array, 0->n-1, no condition for combinations
    //like the previous element not repeated or sum is a specific target
    //base case is the length same as the given array
    static void recurPermutations(int start, int[] arr, int len, List<List<Integer>> combinations, List<Integer> tempList){
        if(len==tempList.size()){
            combinations.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<len;i++){
            if(tempList.contains(arr[i]))continue;
            tempList.add(arr[i]);
            recurPermutations(i+1, arr, len, combinations, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}