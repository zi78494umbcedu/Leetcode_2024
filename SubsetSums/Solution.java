// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        //array to hold the sums of the subsets
        ArrayList<Integer> sumOfSubs = new ArrayList<>();
        recurCallToSubsets(0, 0, arr, sumOfSubs);
        return sumOfSubs;
    }
  //take/not-take method
    static void recurCallToSubsets(int ind, int sum, ArrayList<Integer> arr, ArrayList<Integer> sumOfSubs){
        if(ind==arr.size()){
            sumOfSubs.add(sum);
            return;
        }
        recurCallToSubsets(ind+1, sum+arr.get(ind), arr, sumOfSubs);
        recurCallToSubsets(ind+1, sum, arr, sumOfSubs);
    }
}
