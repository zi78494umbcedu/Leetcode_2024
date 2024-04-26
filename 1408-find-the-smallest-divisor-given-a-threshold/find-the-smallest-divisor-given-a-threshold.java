class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int divisor = 1;
        int low = 1;
        int high = getMax(nums);
        while(low<=high){
            int mid = (low+high)/2;
            if(divisorCeilSum(nums, mid)<=threshold){
                divisor=mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return divisor;
    }

    static int divisorCeilSum(int[] nums, int divisor){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+= Math.ceil((double)nums[i]/(double)divisor);
        }
        //System.out.println("sum is: "+sum+", where divisor is: "+divisor);
        return sum;
    }
    static int getMax(int[] nums){
        int max= Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = max>nums[i]?max:nums[i];
        }
        return max;
    }
}