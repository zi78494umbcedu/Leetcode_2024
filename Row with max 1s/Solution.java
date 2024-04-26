import java.util.ArrayList;
public class Solution
{
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m)
    {
        //binary search method
        int index = -1;
        int max1s = 0;
        for(int i=0;i<n;i++){
            int cnt1s = m-lowerBound(matrix.get(i), m, 1);
            if(cnt1s>max1s){
                max1s = cnt1s;
                index = i;
            }
        }
        return index;



        //brute force method
        // int ith =0;
        // int max1s = -1;
        // for(int i=0;i<n;i++){
        //     int count1s = 0;
        //     for(int j=0;j<m;j++){
        //         count1s+=matrix.get(i).get(j);
        //     }
        //     if(count1s>max1s){
        //         max1s= count1s;
        //         ith =i;
        //     }

        // }
        // return ith;
    }
    static int lowerBound(ArrayList<Integer> matrix, int n, int num){
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix.get(mid)>=num){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
