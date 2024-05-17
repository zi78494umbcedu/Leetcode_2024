class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        /**
        params
        data structure for returning
        given ArrayList
        sum of target
        initial index for recursion
        temp data structure
        */
        getRecurCombinations(combinations, candidates, target, 0, new ArrayList<>());
        return combinations;
    }
    /**
    Recursive call for combinations
    */
    static void getRecurCombinations(List<List<Integer>> combinations, int[] arr, int sum, int ind, List<Integer> tempList){
        //base case if iteration index reaches length of array/last element
        if(ind==arr.length){
            //decreasing the target sum through iteration, if condition met then valid combination
            if(sum==0){
                combinations.add(new ArrayList<>(tempList));
                return;
            }
            //return any case if reached end of array
            return;
        }
        //adding to our recursion stack
        tempList.add(arr[ind]);
        //decreasing the target sum with out element in hand and trying continuing with same element 
        if(arr[ind]<=sum){
            getRecurCombinations(combinations, arr, sum-arr[ind], ind, tempList);
        }
        //removing and going for the "not-take" path, and reverting the target sum without consideration of the previous element
        tempList.remove(tempList.size()-1);
        //not-take path to next element in the array picking
        getRecurCombinations(combinations, arr, sum, ind+1, tempList);
    }
}