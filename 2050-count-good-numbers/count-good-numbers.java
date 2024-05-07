class Solution {
    int mod = (int)1e9+7;
    public int countGoodNumbers(long n) {
        long fives = n%2==0?(n/2):(n/2)+1;
        long fours = n/2;
        long mul1 = pow(5, fives)%mod;
        long mul2 = pow(4, fours)%mod;
        long ans = 1;
        ans =(ans*mul1)%mod;
        ans = (fours!=0)?(ans*mul2)%mod:ans;
        return (int)(ans%mod);
    }

    long pow(long x, long y){
        if(y==0){
            return 1;
        }
        long res = pow(x, y/2);
        if(y%2==0){
            return (res*res)%mod;
        }else{
            return (x*res*res)%mod;
        }
    }
}