class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        //Brute force O(n^2)
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(nums[i]==nums[j])cnt++;
            }
            if(cnt>(n/2))return nums[i];
        }
        return -1;
    }
}