class Solution {

    static void swap(int[] nums1, int[] nums2, int left, int right){
        
            int temp = nums1[left];
            nums1[left] = nums2[right];
            nums2[right]=temp;
        
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length==0)return;
        if(nums2.length==1){
            nums1[nums1.length-1]=nums2[0];
            Arrays.sort(nums1);
            return;
        }
        //optimal 2 GAP METHOD / SHELL SORT
        int len = m+n;
        int gap = (len/2)+(len%2);
        while(gap>0){
            int left=0;
            int right= left+gap;
            while(right<len){
                //num1 && num2
                if(left<m && right>=m){
                    if (nums1[left] > nums2[right - m]) {
                        swap(nums1, nums2, left, right - m);
                    }
                }//num2 && num2
                else if(left>=m){
                    if (nums2[left - m] > nums2[right - m]) {
                        int temp = nums2[left - m];
                        nums2[left - m] = nums2[right - m];
                        nums2[right - m] = temp;
                    }
                    //swap(nums2, nums2, left-m, right-m);
                }//num1 && num1
                else{
                    if (nums1[left] > nums1[right]) {
                        int temp = nums1[left];
                        nums1[left] = nums1[right];
                        nums1[right] = temp;
                    }
                }
                left++;
                right++;
            }
            if(gap==1)break;
            gap = (gap/2)+(gap%2);
        }
        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }   
        Arrays.sort(nums1, 0, m + n);
    }
        
        // //brute force method is n+ 2NlogN using merge sort 
        // //optimal 1 using 2 pointers and replacing elements in the two arrays and then sorting and then merging 
        // int leftPointer=m-1;
        // int rightPointer = 0;
        // //moving back in left and forward in right
        // //step1, placing right elements in both arrays
        // while(leftPointer>=0 && rightPointer<n){
        //     //System.out.println("nums1: "+nums1[leftPointer]+" , nums2: "+nums2[rightPointer]);
        //     if(nums1[leftPointer]>nums2[rightPointer]){
        //         int temp =nums1[leftPointer];
        //         nums1[leftPointer]=nums2[rightPointer];
        //         nums2[rightPointer]= temp;
        //         leftPointer--;
        //         rightPointer++;
        //     }else{
        //         break;
        //     }
        // }
        // //sorting the 2 correct elements arrays now
        // Arrays.sort(nums2);
        // for(int i=m;i<nums1.length;i++){
        //     nums1[i]=nums2[i-m];
        // }
        // Arrays.sort(nums1);
}