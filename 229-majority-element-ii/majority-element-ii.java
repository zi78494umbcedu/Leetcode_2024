class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //brute force
        Set<Integer> result = new HashSet<>();
        List<Integer> resultArray = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(nums[j]==nums[i]){
                    count++;
                }
            }
            if(count>(n/3)){
                result.add(nums[i]);
            }
        }
        resultArray.addAll(result);
        return resultArray;
    }
}