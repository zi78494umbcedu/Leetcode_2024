class Solution {
    public boolean isArmstrong(int n) {
        int len=String.valueOf(n).length();
        int original =n;
        int sum=0;
        
        while(n>0){
            int rem = n%10;
            sum+=Math.pow(rem, len);
            n/=10;
        }
        return original==sum;
    }
}