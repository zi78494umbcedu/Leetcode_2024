class Solution {
    public int climbStairs(int n) {
        //identify DP problem
        /**
        Recursion when:-
        Try all possible ways
        1. "..Count total number of ways"
        2. give best/minimum/maximum
         */
         /**
         Shortcut
         1.represent problem in terms of index
         2. perform computation on the index acc to the problem statement
         3. get sum/min/max acc to the requirement from the index
         */
         if(n<=1)return 1;
         int prev2=1;
         int prev=2;
         for(int i=3;i<=n;i++){
            int curr = prev2+prev;
            prev2=prev;
            prev = curr;
         }
         return prev;
    }
     
}