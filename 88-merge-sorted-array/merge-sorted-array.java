class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //brute force method is n+ 2NlogN using merge sort 
        //optimal 1 using 2 pointers and replacing elements in the two arrays and then sorting and then merging 
        int leftPointer=m-1;
        int rightPointer = 0;
        //moving back in left and forward in right
        //step1, placing right elements in both arrays
        while(leftPointer>=0 && rightPointer<n){
            //System.out.println("nums1: "+nums1[leftPointer]+" , nums2: "+nums2[rightPointer]);
            if(nums1[leftPointer]>nums2[rightPointer]){
                int temp =nums1[leftPointer];
                nums1[leftPointer]=nums2[rightPointer];
                nums2[rightPointer]= temp;
                leftPointer--;
                rightPointer++;
            }else{
                break;
            }
        }
        //sorting the 2 correct elements arrays now
        
        Arrays.sort(nums2);
        
        for(int i=m;i<nums1.length;i++){
            nums1[i]=nums2[i-m];
        }
        Arrays.sort(nums1);
    }
}