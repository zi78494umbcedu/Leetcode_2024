class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> solution =  new ArrayList<String>();
        String str = "";
        generateAllCombinations(solution, 0,0 ,str, n);
        return solution;
    }

    static void generateAllCombinations(List<String> solutionList, int left, int right, String str, int N){
        if(str.length()==N*2){
            solutionList.add(str);
            return;
        }
        if(left<N)generateAllCombinations(solutionList,left+1, right, str+"(", N);
        if(right<left)generateAllCombinations(solutionList,left, right+1, str+")", N);
        
    }
}