class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Optimal approach 2-pointer, removing sorting using set and thus optimising space 
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //i, j, k ->
        //i has to be moved except when the first element until not same
        //condition for when j>=k
        //if sum>0 decrease k
        //if sum<0 increase j
        //if sum==0 decrease k + increase j until new elements 
        int n=nums.length;
        for(int i=0;i<n;i++){
            //i condition
            if(i>0 && nums[i]==nums[i-1])continue;
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum>0){
                   k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    j++;
                    while(j<k && nums[j]==nums[j-1])j++;
                    k--;
                    while(j<k && nums[k]==nums[k+1])k--;
                }
                
            }
        }
        return result;        
        // //Brute force improving to O(n^2) skipping the 3rd loop using hashmap for finding the -(sum[i]+sum[j])
        // int n=nums.length;
        // Set<List<Integer>> set = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     HashMap<Integer, Integer> map = new HashMap<>();
        //     for(int j=i+1;j<n;j++){
        //         int third = -(nums[i]+nums[j]);
        //         if(map.containsKey(third)){
        //             List<Integer> temp = new ArrayList<>();
        //             temp.add(nums[i]);
        //             temp.add(nums[j]);
        //             temp.add(third);
        //             Collections.sort(temp);
        //             set.add(temp);
        //         }
        //         map.put(nums[j],0);
        //     }
        // }
        // List<List<Integer>> result = new ArrayList<>();
        // result.addAll(set);
        // return result;

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