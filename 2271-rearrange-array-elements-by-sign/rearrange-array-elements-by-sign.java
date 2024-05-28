class Solution {
    public int[] rearrangeArray(int[] nums) {
        //better approach with one pass
        int[] answer = new int[nums.length];
        int posIndex=0;
        int negIndex=1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                answer[negIndex] = nums[i];
                negIndex+=2;
            }else{
                answer[posIndex] = nums[i];
                posIndex+=2;
            }
        }
        return answer;
        //brute force O(2*N) + O(N)
        // int n= nums.length;
        // List<Integer> pos = new ArrayList<>(n/2);
        // List<Integer> neg = new ArrayList<>(n/2);
        // for(int i=0;i<n;i++){
        //     if(nums[i]<0){
        //         neg.add(nums[i]);
        //     }else{
        //         pos.add(nums[i]);
        //     }
        // }
        // for(int i=0;i<n/2;i++){
        //     nums[2*i] = pos.get(i);
        //     nums[2*i+1] = neg.get(i);
        // }
        // return nums;
    }
}

