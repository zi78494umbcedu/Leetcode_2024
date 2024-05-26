public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        return secondLargest(n, a);
    }
    static int[] secondLargest(int n, int[] arr){
            int largest = arr[0];
            int sLargest= Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(arr[i]>largest){
                    sLargest = largest;
                    largest = arr[i];
                }else if(arr[i]<largest && arr[i]>sLargest){
                    sLargest = arr[i];
                }
            }
        
            int smallest = arr[0];
            int sSmallest= Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(arr[i]<smallest){
                    sSmallest = smallest;
                    smallest = arr[i];
                }else if(arr[i]>smallest && arr[i]<sSmallest){
                    sSmallest =arr[i];
                }
            }
            return new int[]{sLargest, sSmallest};
    }



}
