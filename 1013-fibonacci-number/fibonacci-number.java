class Solution {
    public int fib(int n) {
        //recurcise approach
        if(n<=1)return n;
        return fib(n-1)+fib(n-2);
        //iterative approach
        // int a =0;
        // int b =1;
        // for(int i=2;i<=n;i++){
        //     int temp = b;
        //     b = a+b;
        //     a = temp;
        // }
        // return b;
    }
}