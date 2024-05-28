class Solution {
    public int majorityElement(int[] nums) {

        //Moore's Voting Algorithm / Optimal Approach O(n) & linear space 
        int element = nums[0];
        int count=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(count==0){
                element = nums[i];
                count++;
            }
            else if(nums[i]==element){
                count++;
            }
            else{
                count--;
            }
            
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(nums[i]==element)cnt++;
        }
        if(cnt>(n/2))return element;
        return -1;
        // int n = nums.length;
        // //better approach O(nlogn)
        // HashMap<Integer, Integer> map = new HashMap<>(); 
        // for(int i=0;i<n;i++){
        //     if(map.containsKey(nums[i])){
        //         map.put(nums[i],map.get(nums[i])+1);
        //     }else{
        //         map.put(nums[i],1);
        //     }
        // }
        // for(Map.Entry<Integer, Integer> it: map.entrySet()){
        //     if(it.getValue()>(n/2)){
        //         return it.getKey();
        //     }
        // }
        // return -1;
        // //Brute force O(n^2)
        // for(int i=0;i<n;i++){
        //     int cnt=0;
        //     for(int j=0;j<n;j++){
        //         if(nums[i]==nums[j])cnt++;
        //     }
        //     if(cnt>(n/2))return nums[i];
        // }
        // return -1;
    }
}