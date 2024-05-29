class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Brute force improving to O(n^2) skipping the 3rd loop using hashmap for finding the -(sum[i]+sum[j])
        int n=nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=i+1;j<n;j++){
                int third = -(nums[i]+nums[j]);
                if(map.containsKey(third)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);
                    Collections.sort(temp);
                    set.add(temp);
                }
                map.put(nums[j],0);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(set);
        return result;

        // //Brute Force - 3 elements - O(n^3)
        // int n = nums.length;
        // Set<List<Integer>> set = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1;k<n;k++){
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                 List<Integer> temp = new ArrayList<>();
        //                 temp.add(nums[i]);
        //                 temp.add(nums[j]);
        //                 temp.add(nums[k]);
        //                 Collections.sort(temp);
        //                 if(!set.contains(temp)){
        //                     set.add(temp);
        //                 }
        //             }
        //         }
        //     }
        // }
        // List<List<Integer>> result = new ArrayList<>();
        // result.addAll(set);
        // return result;
    }
}