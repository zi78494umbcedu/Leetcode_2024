class Solution {
    public List<List<Integer>> generate(int numRows) {
        //better approach
        List<List<Integer>> pascals = new ArrayList<>();
        for(int rows = 0;rows<numRows;rows++){
            List<Integer> pascalRow=new ArrayList<>();
            pascals.add(generateRow(pascalRow, rows));
        }
        return pascals;
        // // //brute force using (R-1)C(N-1)
        // List<List<Integer>> pascals = new ArrayList<>();
        // for(int row=0;row<numRows;row++){
        //     List<Integer> pascalRow= new ArrayList<>();
        //     for(int col=0;col<=row;col++){
        //         pascalRow.add(calculateRCN(row, col));
        //     }
        //     pascals.add(pascalRow);
        // }
        // return pascals;

    }
    static List<Integer> generateRow(List<Integer> rowList, int rowNumber){
            int ans=1;
            rowList.add(1);
            for(int col=0;col<rowNumber;col++){
                ans = ans * (rowNumber-col);
                ans = ans / (col+1);
                //System.out.println(rowNumber+":"+col+":"+ans);
                rowList.add(ans);
            }
            return rowList;
        
    }
    static int calculateRCN(int n, int r){
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