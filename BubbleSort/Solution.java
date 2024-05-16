//Adjacent swapping leads to max pushed to right most of array

public class Solution {
    public static void bubbleSort(int[] arr, int n) {
        for(int i=n-1;i>=1;i--){
            int didSwap=0;
            for(int j=0;j<=i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    didSwap=1;
                }
            }
            if(didSwap==0)break;
        }

        //recursively

        // if(n==1){
        //     return;
        // }
        // int didSwap = 0;
        // for(int i=0;i<=n-2;i++){
        //     if(arr[i]>arr[i+1]){
        //         int temp = arr[i];
        //         arr[i] = arr[i+1];
        //         arr[i+1] = temp;
        //         didSwap=1;
        //     }
        // }
        // if(didSwap==0)return;
        // bubbleSort(arr, n-1);
    }

}
