class Solution {
    public void sortColors(int[] nums) {
        //optimal approach Dutch National Flag Algorithm
        //0-(low-1)     - SWAP(A[low]->A[mid]) & low++ & mid++;
        //low-(mid-1)   - mid++;
        //mid-high      - sorting this section
        //(high+1)-(n-1)- SWAP(A[mid]->A[high]) & high--;
        //WALLAHHH!!...
        int low = 0;
        int mid =low;
        int high =nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                //swap mid and low since remember diagram low has 1-> to make it sorted replace 0 & 1 in correct place
                int temp = nums[mid];
                nums[mid]= nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                //swap the 2 mid with high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }


        // //better approach O(2n)
        // int zeros=0;int ones=0;int twos=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==0){
        //         zeros++;
        //     }
        //     else if(nums[i]==1){
        //         ones++;
        //     }
        //     else if(nums[i]==2){
        //         twos++;
        //     }
        // }
        // //System.out.println(zeros+":"+ones+":"+twos);
        // int i=0;
        // while(zeros!=0){
        //     nums[i]=0;
        //     i++;
        //     zeros--;
        // }
        // while(ones!=0){
        //     nums[i]=1;
        //     i++;
        //     ones--;
        // }
        // while(twos!=0){
        //     nums[i]=2;
        //     i++;
        //     twos--;
        // }
    //brute force MergeSort O(nlogn)
    //  mergeSort(nums, 0, nums.length-1);  
    }
    static void mergeSort(int[] nums, int start, int end){
        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(nums, 0, mid);
        mergeSort(nums, mid+1, end);
        merge(nums, start, mid, end);
    }
    static void merge(int[] nums, int low,int mid,  int high){
        int left=low;
        int right=mid+1;
        ArrayList<Integer> arr = new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                arr.add(nums[left]);
                left++;
            }else{
                arr.add(nums[right]);
                right++;
            }
        }
        while(left<=mid){
            arr.add(nums[left]);
            left++;
        }
        while(right<=high){
            arr.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i] = arr.get(i-low);
        }
    }
}