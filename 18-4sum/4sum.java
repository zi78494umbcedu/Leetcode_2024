class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //optimal approach removing hashset and set for unique answers using sorting initially TC->O(N^2)*O(n)
        //i, j, k, l
        //2 fixed -> i, j iterating
        // moving all with not matching previous iteration value
        //same condition if sum>target then move the latter index., else the former index is moved
        //condition if the non-fixed indices cross paths to break
        //sort the array 
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> result =new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            for(int j=i+1;j<n;j++){
                if(j!=i+1 && nums[j]==nums[j-1])continue;
                int k = j+1;
                int l = n-1;
                while(k<l){
                    long sum = nums[i]+nums[j];
                    sum +=nums[k];
                    sum +=nums[l];
                    sum -= target;
                    if(sum<0){
                        k++;
                    }else if ((sum>0)) {
                        l--;
                    }else{
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        result.add(temp);
                        k++;
                        while(k<l && nums[k]==nums[k-1])k++;
                        l--;
                        while(k<l && nums[l]==nums[l+1])l--;
                    }
                }  
            }
        }
        return result;

        // //brute better with O(n^3) using hashmap for fourth element
        // int n=nums.length;
        // Set<List<Integer>> set = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         Set<Long> hashset =new HashSet<>();
        //         for(int k=j+1;k<n;k++){
        //             long sum = nums[i]+nums[j];
        //             sum+=nums[k];
        //             long fourth = target-sum;
        //             if(hashset.contains(fourth)){
        //                 List<Integer> temp = new ArrayList<>();
        //                 temp.add(nums[i]);
        //                 temp.add(nums[j]);
        //                 temp.add(nums[k]);
        //                 temp.add((int)fourth);
        //                 Collections.sort(temp);
        //                 set.add(temp);
        //             }
        //             hashset.add((long)nums[k]);
        //         }
        //     }
        // }
        // List<List<Integer>> result = new ArrayList<>();
        // result.addAll(set);
        // return result;
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