import java.util.ArrayList;
public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        //binary search
        if(m>n)return -1;
        int low = getMax(arr);
        int high = getSum(arr);
        while(low<=high){
            int mid = (low+high)/2;
            if(getStudentCount(arr, mid)<=m){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
        
        
        
        //linear search
        // if(m>n)return -1;
        // int low = getMax(arr);
        // int high = getSum(arr);
        // for(int i=low;i<=high;i++){
        //     int cntStudents = getStudentCount(arr, i);
        //     if(cntStudents==m)return i;
        // }
        // return -1;
    

    static int getStudentCount(ArrayList<Integer> arr, int pages){
        int students = 1;
        int pagesCount = 0;
        for(int i=0;i<arr.size();i++){
            if(pagesCount+arr.get(i)<=pages){
                pagesCount+=arr.get(i);
            }else{
                students++;
                pagesCount = arr.get(i);
            }
        }
        return students;
    }

    static int getMax(ArrayList<Integer> arr){
        int maxx= Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++){
            maxx=maxx>arr.get(i)?maxx:arr.get(i);
        }
        return maxx;
    }
    static int getSum(ArrayList<Integer> arr){
        int sum=0;
        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
        }
        return sum;
    }
}
