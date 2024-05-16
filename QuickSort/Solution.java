//1.Pick a pivot
//2.smaller on left & bigger on right


public class Solution {
	
	public static void quickSort(int[] input, int startIndex, int endIndex) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * No need to print or return the output.
		 * Taking input and printing output is handled automatically.
		 */
		 quickie(input, startIndex, endIndex);
	}

	static void quickie(int[] arr, int low, int high){
		//condition since low==high => 1 element sorted array
		if(low<high){
			//finding and replacing partition element in array
			int partitionIndex = partition(arr, low, high);
			//left subarray of pivot
			quickie(arr, low, partitionIndex-1);
			//right subarray if pivot
			quickie(arr, partitionIndex+1, high);
		}
	}

	static int partition(int[] arr, int low, int high){
		//let the pivot be selected as the 1st element
		int pivot = arr[low];
		//two pointers for traversing across from start to end of the array
		int i = low;
		int j = high;
		//such that they do not cross
		while(i<j){
			//moving forward with i to swap until finding bigger than pivot
			while(i<=(high-1) && arr[i]<=pivot){
				i++;
			}
			//moving backwards with j to swap until finding smaller than pivot
			while(j>=(low+1) && arr[j]>pivot){
				j--;
			}
			//swapping the smaller than pivot and bigger than pivot elements
			if(i<j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		//swapping the alleged partition at the point of partition
		int temp = arr[j];
		arr[j] = arr[low];
		arr[low] = temp;
		//returning the partition index to recursively do it again with subarrays
		return j;
	}
	
}
