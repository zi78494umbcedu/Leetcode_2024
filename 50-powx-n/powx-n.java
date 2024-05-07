class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (x == 0) return 0.0;
        
        boolean neg = n < 0;
        n = Math.abs(n);
        
        double result = power(x, n);
        
        return neg ? 1 / result : result;
    }
    
    private double power(double x, int n) {
        if (n == 0) return 1.0;
        
        double half = power(x, n / 2);
        
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}
