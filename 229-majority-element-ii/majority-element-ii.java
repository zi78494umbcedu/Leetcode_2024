class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //hasing O(nlogn)
        int n=nums.length;
        int minReq = (n/3)+1;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>(); 
        for(int i=0;i<n;i++){
            int freq = map.getOrDefault(nums[i], 0); 
            map.put(nums[i], freq+1);
            if(map.get(nums[i])==minReq){
                result.add(nums[i]);
            }           
            if(result.size()==2)break;
        }
        return result;
        //brute force 2 using 
        // List<Integer> res = new ArrayList<>();
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     //checking if nums[i] if not already part of the answer
        //     if(res.size()==0 || res.get(0)!=nums[i]){
        //         int cnt=0;
        //         for(int j=0;j<n;j++){
        //             if(nums[j]==nums[i]){
        //                 cnt++;
        //             }
        //         }
        //         if(cnt>(n/3)){
        //             res.add(nums[i]);
        //         }
        //     }
        //     if(res.size()==2)break;
        // }
        // return res;
        //brute force
        // Set<Integer> result = new HashSet<>();
        // List<Integer> resultArray = new ArrayList<>();
        // int n = nums.length;
        // for(int i=0;i<n;i++){
        //     int count=0;
        //     for(int j=0;j<n;j++){
        //         if(nums[j]==nums[i]){
        //             count++;
        //         }
        //     }
        //     if(count>(n/3)){
        //         result.add(nums[i]);
        //     }
        // }
        // resultArray.addAll(result);
        // return resultArray;
    }
}