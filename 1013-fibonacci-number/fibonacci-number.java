class Solution {
    //step0 = declare dynamic programming 1D array
    private int[] dp;
    public int fib(int n) {
        //tabulation with no space 
        int prev = 1;
        int prev2 =0;
        if(n==0)return 0;
        for(int i=2;i<=n;i++){
            int curr = prev2+prev;
            prev2 =prev;
            prev = curr;
        }
        return prev;
        //tabulation 
    //     dp = new int[n+1];
    //    dp[0]=0;
    //    dp[1]=1;

    //    for(int i=2;i<=n;i++){
    //     dp[i] = dp[i-1]+dp[i-2];
    //    }
    //    return dp[n];
        // dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // //recurcise approach
        // if(n<=1)return n;
        // //step1 = base case
        // if(dp[n]!=-1)return dp[n];
        // //step2 = main computation
        // return dp[n]=fib(n-1)+fib(n-2);
        // //iterative approach
        // // int a =0;
        // // int b =1;
        // // for(int i=2;i<=n;i++){
        // //     int temp = b;
        // //     b = a+b;
        // //     a = temp;
        // // }
        // // return b;
    }
}