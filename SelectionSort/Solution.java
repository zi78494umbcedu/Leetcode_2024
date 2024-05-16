//pushing the min to the leftmost with comparing the rest array and replacing the min to the left of the array iteratively
public class Solution {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        //iterating over the loop for minumum from 1st number to n-2, 
        //since last number trivial to compare for minimum
        for(int i=0;i<=n-2;i++){
            //having 1st element of loop as minimum for having lowest of the subarray over here
            int min = i;
            //iterating over subarray
            for(int j=i;j<=n-1;j++){
                //if min found
                if(arr[min]>arr[j]){
                    //replace index for further swapping with the first element
                    min= j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
