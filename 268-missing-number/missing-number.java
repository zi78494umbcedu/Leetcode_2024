class Solution {
    public int missingNumber(int[] nums) {
    //optimal approach xor approach
    int xor1=nums.length;
    for(int i=0;i<nums.length;i++){
        xor1 =xor1^i^nums[i];
    }
    return xor1 ;
    //optimal approach sum approach
    // int sum=0;
    // int shouldBeSum = nums.length*(nums.length+1)/2;
    // for(int i=0;i<nums.length;i++){
    //     sum+=nums[i];
    // }
    // return shouldBeSum-sum;
    // //better approach using a hashmap O(2n)
    // HashMap<Integer, Integer> hashmap = new HashMap<>(nums.length+1);
    // for(int i=0;i<nums.length;i++){
    //     hashmap.put(nums[i], 1);
    // }
    // System.out.println(hashmap);
    // for(int i=0;i<=nums.length;i++){
    //     if(!hashmap.containsKey(i))return i;
    // }
    // return -1;
    //   //brute force method O(n^2)
    //   //looping to check each number
    //   for(int i=0;i<=nums.length;i++){
    //     //looping over the array
    //     boolean found = false;
    //     for(int j=0;j<nums.length;j++){
    //         if(nums[j]==i)found=true;
    //     }
    //     if(!found)return i;
    //   }
    //   return -1;  
    }
}