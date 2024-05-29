class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //optimal approach Moore's Voting Algorithm with (element, count). Will the same work? 2 majority elements >n/3. (element1, count1), (element2, count2)
        List<Integer> answer = new ArrayList<>(); 
        int element1 = Integer.MIN_VALUE;
        int element2=Integer.MIN_VALUE;
        int count2=0;
        int count1=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(count1==0 && nums[i]!=element2){
                count1=1;
                element1=nums[i];
            }else if(count2==0 && nums[i]!=element1){
                count2=1;
                element2=nums[i];
            }else if(element1==nums[i]){
                count1++;
            }else if(element2==nums[i]){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        int cntElement1=0;
        int cntElement2=0;
        for(int el:nums){
            if(el==element1){
                cntElement1++;
            }
            if(el==element2){
                cntElement2++;
            }
        }
        if(cntElement1>(n/3)){
            answer.add(element1);
        }
    
        if(cntElement2>(n/3)){
            answer.add(element2);
        }
        return answer;
        

        // //hasing O(nlogn)
        // int n=nums.length;
        // int minReq = (n/3)+1;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // List<Integer> result = new ArrayList<>(); 
        // for(int i=0;i<n;i++){
        //     int freq = map.getOrDefault(nums[i], 0); 
        //     map.put(nums[i], freq+1);
        //     if(map.get(nums[i])==minReq){
        //         result.add(nums[i]);
        //     }           
        //     if(result.size()==2)break;
        // }
        // return result;
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