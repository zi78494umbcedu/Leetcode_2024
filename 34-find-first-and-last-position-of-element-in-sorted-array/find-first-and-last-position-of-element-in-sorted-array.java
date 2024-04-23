class Solution {
    public int[] searchRange(int[] nums, int target) {
        //using plain binary search
        int len = nums.length;
        int first = binSearchFirst(nums, target, len);
        if(first==-1)return new int[]{-1, -1};
        int last = binSearchLast(nums, target, len);
        return new int[]{first, last};
        //upper/lower bound
        // int first = lowerBound(nums, target);
        // if(first ==nums.length || nums[first]!=target)return new int[]{-1, -1};
        // int last = upperBound(nums, target);
        // return new int[]{first, last};
        
        //brute force
        // int first=-1;
        // int second =-1;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==target){
        //         if(first==-1)first=i;
        //         second = i;
        //     }
        // }
        // return new int[]{first, second};
    }
    static int binSearchLast(int[] nums, int target, int len){
        int start = 0;
        int end = len-1;
        int last = -1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                last = mid;
                start = mid+1;
            }else if(nums[mid]<target){
                start= mid+1;
            }else{
                end = mid-1;
            }
        }
        return last;
    }
    static int binSearchFirst(int[] nums, int target, int len){
        int start = 0;
        int end = len-1;
        int first=-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                first=mid;
                end= mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return first;
    }

    static int lowerBound(int[] nums, int target){
        int start = 0;
        int len = nums.length;
        int end = len-1;
        int ans=len;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]>=target){
                ans=mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    static int upperBound(int[] nums, int target){
        int start = 0;
        int len = nums.length;
        int end = len-1;
        int ans=len;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]>target){
                ans=mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans-1;
    }
}