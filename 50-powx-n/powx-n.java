class Solution {
    public double myPow(double x, int n) {
        //binomial exponential approach
        if(n==0)return 1;
        if(x==0)return 0;
        boolean neg=n<0?true:false;
        n=Math.abs(n);
        double pow = power(x, n);
        return neg?1/pow:pow;
        //brute force
        // if(n==0 ||x==0)return 1;
        // if(n<0)return myPow(x, -n);
        // return x*myPow(x, n-1);
    }

    static double power(double x, int n){
        if(n==0)return 1;
        double half = power(x, n/2);
        if(n%2==0){
            return half*half;
        }else{
            return x*half*half;
        }
    }
}