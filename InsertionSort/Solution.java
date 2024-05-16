//takes an element and places it in its correct place

public class Solution {
    public static void insertionSort(int[] arr, int size) {
        for(int i=0;i<=size-1;i++){
            int j=i;
            //since  max with last element in array comparison
            //be with the first element, so to avoid j-1 going
            //index out of bounds exception j has to be >0
            while(j>0 && arr[j-1]>arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }


    //     //recursive approach
    //    if (size <= 1) {
    //         return;
    //     }
    //     // Sort first n-1 elements
    //     insertionSort(arr, size - 1);
    //     // Insert last element at its correct position in sorted array
    //     int last = arr[size - 1];
    //     int j = size - 2;
    //     while (j >= 0 && arr[j] > last) {
    //         arr[j + 1] = arr[j];
    //         j--;
    //     }
    //     arr[j + 1] = last;
    }
}
