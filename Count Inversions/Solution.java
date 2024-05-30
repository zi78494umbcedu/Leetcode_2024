import java.util.ArrayList;

public class Solution {
    public static int numberOfInversions(int []a, int n) {
        //optimal approach using merge sort
        return mergeSort(a,0, n-1);
        // int count=0;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(a[i]>a[j]){
        //             count++;
        //         }
        //     }
        // }
        // return count;
    }

    static int mergeSort(int[] arr, int low, int high){
        //base case
        int cnt=0;
        if(low>=high){
            return cnt;
        }
        //divide
        int mid = (low+high)/2;
        //divide into big and smaller arrays => i.e., in case of odd lengthed array
        cnt+=mergeSort(arr, low, mid);
       cnt+= mergeSort(arr, mid+1, high);
        //calling the merge algorithm once the base case hits to complete the divide and merge
        cnt+=mergeThem(arr, low, mid, high);
        return cnt;
    }

    static int mergeThem(int[] arr, int low, int mid, int high){
        //two pointers to move through the two arrays
        //1.low to mid 
        //2.mid+1 to high
        //temp array to store the sorted array
        int cnt=0;
        ArrayList<Integer> temp = new ArrayList<>();
        int left=low;
        int right = mid+1;
        // together case:=> until left subarray and right subarray both have elements
        while(left<=mid && right<=high){
            //Ascending: if left subarray has smaller element then add
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
                cnt+=(mid-left+1);
            }
        }
        //if right subarray has exhausted before the left subarray
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        //if left subarray has exhausted before the right subarray
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        //adding back to the original orray from temp
        for(int i=low;i<=high;i++){
            arr[i] = temp.get(i-low);
        }
        return cnt;
    }

}
