class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //brute better with O(n^3) using hashmap for fourth element
        int n=nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Long> hashset =new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long sum = nums[i]+nums[j];
                    sum+=nums[k];
                    long fourth = target-sum;
                    if(hashset.contains(fourth)){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int)fourth);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    hashset.add((long)nums[k]);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(set);
        return result;
        // //Brute force O(n^4)+O(nlogn) since need 4 elements, O(nlogn)+O(n) since hashset and set for unique
        // int n=nums.length;
        // Set<List<Integer>> set = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1;k<n;k++){
        //             for(int l=k+1;l<n;l++){
        //                 if(target==(nums[i]+nums[j]+nums[k]+nums[l])){
        //                     List<Integer> temp = new ArrayList<>();
        //                     temp.add(nums[i]);
        //                     temp.add(nums[j]);
        //                     temp.add(nums[k]);
        //                     temp.add(nums[l]);
        //                     Collections.sort(temp);
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