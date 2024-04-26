class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(m*k))return -1;
        int high = getMax(bloomDay);
        int low = getMin(bloomDay);
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            int possibleBouquets = getBouquetsMade(bloomDay, k, mid);
            if(possibleBouquets>=m){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    static int getBouquetsMade(int[] bloomDay, int k, int days){
        int bouquets = 0;
        int consecCount = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=days){
                consecCount++;
                if(consecCount==k){
                    bouquets++;
                    consecCount=0;
                }
            }
            else{
                consecCount=0;
            }
            if(consecCount==k)bouquets++;
        }
        return bouquets;
    }
    static int getMin(int[] bloomDay){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            min = min<bloomDay[i]?min:bloomDay[i];
        }
        return min;
    }



    static int getMax(int[] bloomDay){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            max = max>bloomDay[i]?max:bloomDay[i];
        }
        return max;
    }
}