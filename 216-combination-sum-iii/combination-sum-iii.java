class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        recurCallCombinations(k, n, 1, combinations, new ArrayList<>());
        return combinations;
    }
    static void recurCallCombinations(int len, int sum,int start,  List<List<Integer>> combinations, List<Integer> tempList){
        if(tempList.size()==len){
            if(sum==0){
                combinations.add(new ArrayList<>(tempList));
                return;
            }
            return;
        }
        for(int i=start;i<=9;i++){
            if(i>sum){
                break;
            }
            tempList.add(i);
            recurCallCombinations(len, sum-i,i+1, combinations, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}