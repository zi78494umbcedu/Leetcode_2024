
class Solution {

    static int numberOfGasStations(int[] arr, double mid){
        int cnt = 0;
        for(int i=1;i<arr.length;i++){
            double numberInBetween = (arr[i]-arr[i-1])/(double)mid;
            if((arr[i]-arr[i-1])/mid == numberInBetween*mid){
                numberInBetween--;
            }
            cnt+=numberInBetween;
        }
        return cnt;
    }
      
    public  double minmaxGasDist(int[] arr, int k) {
        int n = arr.length;
        double low = 0;
        double high = 0;
        for(int i=0;i<n-1;i++){
            high = Math.max(high, (double)(arr[i+1]-arr[i]));
        }
        double diff = 1e-6;
        while(high-low>diff){
            double mid = (low+high)/2.0;
            int cnt = numberOfGasStations(arr, mid);
            if(cnt>k){
                low=mid;
            }else{
                high=mid;
            }
        }
        return high;

    }
    public static class Pair{
        double first;
        int second;

        Pair(double first, int second){
        this.first = first;
        this.second = second;
        }
    } 
        //PriorityQueue method
    //     int n = arr.length; // size of array.
    //     //arr to store sections with number of stations insertedd
    //     int[] howMany = new int[n - 1];
    //     PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

    //     // insert the first n-1 elements into pq
    //     // with respective distance values:
    //     for (int i = 0; i < n - 1; i++) {
    //         pq.add(new Pair(arr[i + 1] - arr[i], i));
    //     }

    //     // Pick and place k gas stations:
    //     for (int gasStations = 1; gasStations <= k; gasStations++) {
    //         // Find the section with maximum first(diff between stations)
    //         // and insert the gas station:
    //         Pair tp = pq.poll();
    //         //get count of insertions
    //         int secInd = tp.second;
    //         // insert the current gas station:
    //         howMany[secInd]++;
    //         //difference between the sections after insertion
    //         double inidiff = arr[secInd + 1] - arr[secInd];
    //         double newSecLen = inidiff / (double) (howMany[secInd] + 1);
    //         pq.add(new Pair(newSecLen, secInd));
    //     }

    //     return pq.peek().first;
    // }
        //brute force method 
       // int[] sections = new int[stations.length-1];
    //     for(int i=1;i<=k;i++){
    //         //track how many placed in sections-wise
    //         int maxIndex = -1;
    //         double maxDist = -1;
    //         for(int j=0;j<stations.length-1;j++){
    //             double diff = stations[j+1] - stations[j];
    //             double sectionLen = diff/(double)(sections[j]+1);
    //             if(maxDist<sectionLen){
    //                 maxDist = sectionLen;
    //                 maxIndex = j;
    //             }
                
    //         }
    //         sections[maxIndex]++;
    //     }
    //     double maxAns = -1;
    //     for(int i=0;i<stations.length-1;i++){
    //        double sectionLen = (double)(stations[i+1]-stations[i])/(double)(sections[i]+1);
    //        maxAns = Math.max(sectionLen, maxAns);
    //     }
    //     return maxAns;
    // }
}