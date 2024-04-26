class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //binary search method optimised
    int n1 = nums1.length;
    int n2 = nums2.length;
    if(n1>n2)return findMedianSortedArrays(nums2, nums1);
    int low = 0;
    int high = n1;
    int left = (n1+n2+1)/2;
    int n = (n1+n2);
    while(low<=high){
        int mid1 =(low+high)>>1;
        int mid2 = left-mid1;
        int l1 = Integer.MIN_VALUE;
        int l2 = Integer.MIN_VALUE;
        int r1 = Integer.MAX_VALUE;
        int r2 = Integer.MAX_VALUE;
        if(mid1<n1) r1 = nums1[mid1];
        if(mid2<n2) r2 = nums2[mid2];
        if(mid1-1>=0) l1 = nums1[mid1-1];
        if(mid2-1>=0) l2 = nums2[mid2-1];
        if(l1<=r2 && l2<=r1){
            if(n%2==1){
                return Math.max(l1, l2);
            }else{
                return (double)(Math.max(l1, l2)+Math.min(r1, r2))/2.0;
            }
        }else if(l1>r2){
            high = mid1-1;
        }else{
            low = mid1+1;
        }
    }
    return 0;
    }
    





        //optimised brute force method 
    //     if(nums1.length==0){
    //         if(nums2.length!=0 && nums2.length%2==1){
    //             return (double)nums2[nums2.length/2];
    //         }else{
    //             return (double)(nums2[nums2.length/2]+nums2[nums2.length/2-1])/2.0;
    //         }
    //     }
    //     if(nums2.length==0){
    //         if(nums1.length!=0 && nums1.length%2==1){
    //             return nums1[nums1.length/2];
    //         }else{
    //              return (double)(nums1[nums1.length/2]+nums1[nums1.length/2-1])/2.0;
    //         }
    //     }
    //     int n1 = nums1.length;
    //     int n2 = nums2.length;
    //     int i=0;
    //     int j=0;
    //     int n = (n1+n2);
    //     int cnt = 0;
    //     int ind2 = n/2;
    //     int ind1 = ind2-1;
    //     int ind1el = -1;
    //     int ind2el = -1;
    //     while(i<n1 && j<n2){
    //         if(nums1[i]<nums2[j]){
    //             if(cnt==ind1)ind1el = nums1[i];
    //             if(cnt==ind2)ind2el = nums1[i];
    //             cnt++;
    //             i++;
    //         }else{
    //             if(cnt==ind1)ind1el = nums2[j];
    //             if(cnt==ind2)ind2el = nums2[j];
    //             cnt++;
    //             j++; 
    //         }     
    //     }
    //     if(i<n1){
    //         if(cnt==ind1)ind1el = nums1[i];
    //         if(cnt==ind2)ind2el = nums1[i];
    //         cnt++;
    //         i++;
    //     }
    //     if(j<n2){
    //         if(cnt==ind1)ind1el = nums2[j];
    //         if(cnt==ind2)ind2el = nums2[j];
    //         cnt++;
    //         j++;
    //     }
    //     if(n%2==1){
    //         return ind2el;
    //     }else{
    //         return (double)((double)(ind1el+ind2el))/2.0;
    //     }
    // }
        //brute force method
    //     int[] nums3= new int[nums1.length+nums2.length];
    //     int i = 0;
    //     int j = 0;
    //     int k = 0;
    //     while(i<nums1.length && j<nums2.length){
    //         if(nums1[i]<nums2[j]){
    //             nums3[k] = nums1[i++];
    //             k++;
    //         }else{
    //             nums3[k] = nums2[j++];
    //             k++;
    //         }
    //     }
    //     if(i<nums1.length){
    //         nums3[k] = nums1[i++];
    //          k++;
    //     }
    //     if(j<nums2.length){
    //         nums3[k] = nums2[j++];
    //         k++;
    //     }
    //     if(nums3.length%2==1)return (double)nums3[nums3.length/2];
    //     else{
    //         return ((double)nums3[nums3.length/2] + (double)nums3[nums3.length/2-1])/2.0;
    //     }
    // }
}