import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ind = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                    ind[1]=i;
                    ind[0]=map.get(target-nums[i]);
                    return ind;
            }
            map.put(nums[i], i);
        }
        return ind;
    }
}