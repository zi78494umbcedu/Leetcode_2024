class Solution {
    public int[] twoSum(int[] nums, int target) {
        //optimal approach
        //using 2 pointer after sorting, add to left and subtract from right if sum is less and more respectively
        //better approach hashing O(nLogn)
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
        //brute force O(n^2)
        // for(int i=0;i<nums.length;i++){
        //      for(int j=i+1;j<nums.length;j++){
        //         if(nums[j]+nums[i]==target){
        //             return new int[]{i, j};
        //         }
        //      }
        // }
        // return new int[]{};
    }
}