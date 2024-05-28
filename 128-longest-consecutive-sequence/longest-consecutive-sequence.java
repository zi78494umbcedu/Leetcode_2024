class Solution {
    public int longestConsecutive(int[] nums) {
        //optimal approach using set
        
        int n=nums.length;
        if(n==0)return 0;
        Set<Integer> set = new HashSet<>(n);
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int longest=1;
        for(int it: set){
            if(!set.contains(it-1)){
                int count=1;
                while(set.contains(it+1)){
                    it++;
                    count++;
                }
                longest=Math.max(longest, count);
                
            }
        }
        return longest;
        // //better approach with sorting
        // Arrays.sort(nums);
        // int longest=1;
        // int currentLen =1;
        // int prevMin = Integer.MIN_VALUE;
        // int n=nums.length;
        // if(n==0)return 0;
        // for(int i=0;i<n;i++){
        //     if(prevMin+1==nums[i]){
        //         currentLen+=1;
        //         prevMin = nums[i];
                
        //     }else if(prevMin!=nums[i]){
        //         currentLen=1;
        //         prevMin = nums[i];
        //     }
        //     longest = Math.max(longest, currentLen);
        // }
        // return longest;
        // //brute force
        // int maxLen =1;
        // int n = nums.length;
        // if(n==0)return 0;
        // for(int i=0;i<n;i++){
        //     int count=1;
        //     int current = nums[i];
        //     for(int j=0;j<n;j++){
        //         if(current+1==nums[j]){
        //             count++;
        //             current = nums[j];
        //             //resetting the inner counter to search the next number in the entire array
        //             j=-1; 
        //         }
        //     }
        //     maxLen = Math.max(maxLen, count);
        // }
        // return maxLen;
    }
}
//1,2,3,4,100,200