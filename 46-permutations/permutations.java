

import static java.util.Collections.swap;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //number of permutations is len!; || 3!=6
        List<List<Integer>> combinations = new ArrayList<>();
        //extra space recursion
        //recurPermutations(0, nums, nums.length, combinations, new ArrayList<>());
        recurSwappingPermutations(0, nums, combinations);
        return combinations;
    }


    static void recurSwappingPermutations(int ind, int[] nums, List<List<Integer>> combinations){
        if(ind==nums.length){
           List<Integer> tempList = new ArrayList<>();
           for(int i=0;i<nums.length;i++){
            tempList.add(nums[i]);
           }
           combinations.add(new ArrayList<>(tempList));
           return;
        }
        for(int i=ind;i<nums.length;i++){
            //swap with same index
            swapLocal(i, ind, nums);
            recurSwappingPermutations(ind+1, nums, combinations);
            swapLocal(i, ind, nums);
        }
    }
    static void swapLocal(int i, int j, int[] arr){
        int temp  = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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