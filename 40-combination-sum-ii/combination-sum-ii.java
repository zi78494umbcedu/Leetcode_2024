class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //optimal solution with combination pattern part 2 -> looping over combination of choices instead of only the adjacent index
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates); 
        callRecurCombinationsTwo(combinations, candidates, target, 0, new ArrayList<>());
        return combinations;
        //O(2^n*k*Logn) due to hashSet
        // Set<List<Integer>> setCombinations = new HashSet<>();
        // List<List<Integer>> combinations = new ArrayList<>();
        // List<Integer> arr = new ArrayList<>();
        // for(int i=0;i<candidates.length;i++){
        //     arr.add(candidates[i]);
        // }
        // Collections.sort(arr);
        // getRecurCombinations(setCombinations, arr, target, 0, new ArrayList<>());
        // combinations.addAll(setCombinations);
        // return combinations;
    }
    /**
    */
    static void callRecurCombinationsTwo(List<List<Integer>> combinations, int[] arr, int target, int ind, List<Integer> tempList){
        if(target==0){
            combinations.add(new ArrayList<>(tempList));
            return;
        }
        //new combinations pattern, choice to select any next index element, note: array is sorted
        for(int i=ind;i<arr.length;i++){
            //if previous element is same as current then continue
            if(i>ind && arr[i]==arr[i-1])continue;
            //if there is no element found further that can make target sum then skip the combination since invalid 
            if(target<arr[i])break;
            tempList.add(arr[i]);
            callRecurCombinationsTwo(combinations, arr, target-arr[i], i+1, tempList);
            tempList.remove(tempList.size()-1);
            //recursion call not required here since random choice made and not the usual take/not-take theme
        }
        

    }
    /**
    Recursive call for combinations
        params
        data structure for returning
        given ArrayList
        sum of target
        initial index for recursion
        temp data structure
    */
    static void getRecurCombinations(Set<List<Integer>> setCombinations, List<Integer> arr, int sum, int ind, List<Integer> tempList){
        //base case if iteration index reaches length of array/last element
        if(ind==arr.size()){
            //decreasing the target sum through iteration, if condition met then valid combination
            if(sum==0){
                Collections.sort(tempList);
                setCombinations.add(new ArrayList<>(tempList));
                return;
            }
            //return any case if reached end of array
            return;
        }
        
        if(arr.get(ind)<=sum){
            //adding to our recursion stack
            tempList.add(arr.get(ind));
            //decreasing the target sum with out element in hand and trying continuing with same element 
            getRecurCombinations(setCombinations, arr, sum-arr.get(ind), ind+1, tempList);
            //removing and going for the "not-take" path, and reverting the target sum without consideration of the previous element
            tempList.remove(tempList.size()-1);
        }
        //not-take path to next element in the array picking
        getRecurCombinations(setCombinations, arr, sum, ind+1, tempList);
    }
}