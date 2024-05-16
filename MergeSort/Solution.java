import java.util.ArrayList;

public class Solution {
	public static void mergeSort(int[] arr, int n) {
        //low to high, low=0, high=n-1
		mergeIt(arr, 0, n-1);
	}

    static void mergeIt(int[] arr, int low, int high){
        //base case
        if(low>=high){
            return;
        }
        //divide
        int mid = (low+high)/2;
        //divide into big and smaller arrays => i.e., in case of odd lengthed array
        mergeIt(arr, low, mid);
        mergeIt(arr, mid+1, high);
        //calling the merge algorithm once the base case hits to complete the divide and merge
        mergeThem(arr, low, mid, high);
    }

    static void mergeThem(int[] arr, int low, int mid, int high){
        //two pointers to move through the two arrays
        //1.low to mid 
        //2.mid+1 to high
        //temp array to store the sorted array
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
    }
}
