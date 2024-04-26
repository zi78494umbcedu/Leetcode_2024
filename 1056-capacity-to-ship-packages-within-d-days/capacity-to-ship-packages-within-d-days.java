class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int low = getMax(weights);
       int high = getSum(weights); 
       while(low<=high){
            int mid= (low+high)/2;
            if(getDaysAtCapacity(weights,  mid)<=days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    static int getDaysAtCapacity(int[] weights, int capacity){
        int days=1;
        int load = 0;
        for(int i=0;i<weights.length;i++){
            if(load+weights[i]>capacity){
                days+=1;
                load = weights[i];
            }else{
                load+=weights[i];
            }
        }
        return days;
    }

    static int getSum(int[] weights){
        int sum = 0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
        }
        return sum;
    }
    static int getMax(int[] weights){
        int maxx = Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++){
            maxx = maxx>weights[i]?maxx:weights[i];
        }
        return maxx;
    }
}