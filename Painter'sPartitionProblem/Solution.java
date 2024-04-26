import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int low = getMax(boards);
        int high = getSum(boards);
        while(low<=high){
            int mid= (low+high)/2;
            if(getSubArray(boards, mid )<=k){
                high = mid-1;
            }else{
                low  = mid+1;
            }
        }
        return low;
    }

    static int getSubArray(ArrayList<Integer> arr, int sum){
        int maxSum=0;
        int sizeArray = 1;
        for(int i=0;i<arr.size();i++){
            if(maxSum+arr.get(i)<=sum){
                maxSum+=arr.get(i);
            }else{
                sizeArray ++;
                maxSum = arr.get(i);
            }
        }
        return sizeArray;
    }

    static int getMax(ArrayList<Integer> arr){
        int maxx= Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++){
            maxx = maxx>arr.get(i)?maxx:arr.get(i);
        }
        return maxx;
    }

    static int getSum(ArrayList<Integer> arr){
        int sum =0;
       for(int i=0;i<arr.size();i++){
           sum+=arr.get(i);
       }
       return sum;
    }
}
