class Solution {
    public List<List<Integer>> generate(int numRows) {
        //brute force using (R-1)C(N-1)
        List<List<Integer>> pascals = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> pascalRow= new ArrayList<>();
            for(int j=0;j<=i;j++){
                pascalRow.add(calculateRCN(j, i));
            }
            pascals.add(pascalRow);
        }
        return pascals;

    }
    static int calculateRCN(int r, int n){
        if(r==0 || n==r)return 1;
        //10C2 = 10*9/1*2
        int res=1;
        if(r>n-r)r= n-r;
        for(int i=0;i<r;i++){
            res*=(n-i);
            res/=(i+1);
        }
        return res;
    }
}