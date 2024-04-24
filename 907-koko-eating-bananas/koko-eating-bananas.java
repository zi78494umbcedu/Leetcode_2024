class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = getMaxOfArray(piles);
        System.out.print("high is: "+high);
        while(low<=high){
            int mid = (low+high)/2;
            int totalHours = getTotalHours(piles, mid);
            System.out.println("total hours for mid is: "+totalHours);
            if(totalHours<=h){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
        // int last = piles[piles.length-1];
        // for(int i=1;i<last;i++){
        //     int totalHours = getTotalHours(piles, i);
        //     if(totalHours<=h){
        //         return i;
        //     }
        // }
        // return 1;
    }
    static int getMaxOfArray(int[] piles){
        int max= Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max = max>piles[i]?max:piles[i];
        }
        return max;
    }
    static int getTotalHours(int[] piles, int hourly){
        int totalHours = 0;
        for(int i=0;i<piles.length;i++){
            totalHours+=Math.ceil((double)piles[i]/(double)hourly);
        }
        //System.out.println("final total hours with hourly rate: "+hourly+" : "+totalHours);
        return totalHours;
    }
}