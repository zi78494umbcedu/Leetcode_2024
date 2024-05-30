class Solution {

    static int countPairs(int[] arr, int low, int mid, int high){
        int right= mid+1;
        int cnt=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && arr[i]>(2L*arr[right])){
                right++; 
            }
            cnt+=(right-(mid+1));
        }
        return cnt;
    }
    static void mergeThem(int[] arr, int low, int mid, int high){
        int left= low;
        int right = mid+1;
        ArrayList<Integer> list = new ArrayList<>();
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            list.add(arr[left]);
            left++;
        }
        while(right<=high){
            list.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i] = list.get(i-low);
        }
    }
    static int mergeSort(int[] arr, int low, int high){
        int cnt=0;
        if(low>=high){
            return cnt;
        }
        int mid = (low+high)/2;
        cnt+=mergeSort(arr, low, mid);
        cnt+=mergeSort(arr, mid+1, high);
        cnt+=countPairs(arr, low, mid, high);
        mergeThem(arr, low, mid, high);
        return cnt;
    }
    public int reversePairs(int[] nums) {
        //optimal approach to nlogn is using merge sort with counting pairs
        return mergeSort(nums, 0, nums.length-1);
        // //brute force O(n^2)
        // int cnt=0;
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]>(2*nums[j])){
        //             cnt++;
        //         }
        //     }
        // }
        // return cnt;
    }
}