class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        getRecurCombinations(combinations, candidates, target, 0, new ArrayList<>());
        return combinations;
    }
    static void getRecurCombinations(List<List<Integer>> combinations, int[] arr, int sum, int ind, List<Integer> tempList){
        if(ind==arr.length){
            if(sum==0){
                combinations.add(new ArrayList<>(tempList));
                return;
            }
            return;
        }
        tempList.add(arr[ind]);
        if(arr[ind]<=sum){
            getRecurCombinations(combinations, arr, sum-arr[ind], ind, tempList);
        }
        tempList.remove(tempList.size()-1);
        getRecurCombinations(combinations, arr, sum, ind+1, tempList);
    }
}