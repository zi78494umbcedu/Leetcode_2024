

import java.util.Arrays; 

class Solution {
    public static int aggressiveCows(int []stalls, int k) {
        //sort stalls array
        Arrays.sort(stalls);       
        int high = stalls[stalls.length-1]-stalls[0];
        int low =   1;
        while(low<=high){
            int mid = (low+high)/2;
            if(canWePlaceCows(stalls, mid, k)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }

    static boolean canWePlaceCows(int[] stalls, int dist, int cows){
        int cntCows = 1;
        int last = stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i] - last>=dist){
                cntCows++;
                last = stalls[i];
            }
        }
       if(cntCows>=cows)return true;
       return false;
    }

    static int getMax(int[] stalls){
        int maxx = Integer.MIN_VALUE;
        for(int i=0;i<stalls.length;i++){
            maxx = maxx>stalls[i]?maxx:stalls[i];
        }
        return maxx;
    }
    static int getMin(int[] stalls){
        int minn = Integer.MAX_VALUE;
        for(int i=0;i<stalls.length;i++){
            minn = minn<stalls[i]?minn:stalls[i];
        }
        return minn;
    }
}
