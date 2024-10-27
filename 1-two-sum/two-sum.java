class Solution {
    public int[] twoSum(int[] nums, int target) {
        //brute force by traversing through the array - O(n^2)
        // int n=nums.length;
        // for(int i=0;i<n-1;i++){
        //     for(int j=1;j<n;j++){
        //         if(nums[i]+nums[j]==target){
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return new int[]{0,0};

        // using a Hashmap to add all of the array and then traversing through once 
        // for each number with target - the number match
        // check for same index
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put( nums[i], i);
        }
        for(int i=0;i<n;i++){
            if(map.get(target - nums[i])!=null && map.get(target-nums[i])!=i){
                return new int[]{i, map.get(target - nums[i])};
            }else{
                continue;
            }
        }
        return new int[]{};
    }
}