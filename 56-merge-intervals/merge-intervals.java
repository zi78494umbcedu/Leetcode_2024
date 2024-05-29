class Solution {
    public int[][] merge(int[][] intervals) {
        //in one pass O(n)
        //step1 sorting
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        int n = intervals.length;
        List<int[]> response = new ArrayList<>();
        for(int i=0;i<n;i++){
            //adding new interval 1.if nothing present or if new interval that is not overlapping
            if(response.isEmpty() || intervals[i][0]>response.get(response.size()-1)[1]){
                response.add(intervals[i]);
            //otherwise just update the 2nd element/end of the interval present for merging intervals
            }else{
                response.get(response.size()-1)[1] = Math.max(response.get(response.size()-1)[1],intervals[i][1]);
            }
        }
        return response.toArray(new int[response.size()-1][]);
        // //step1 sorting -> step2 comparing 1.2, 2.1 and merge
        // //sorting the array
        // Arrays.sort(intervals, new Comparator<int[]>(){
        //     public int compare(int[] a,int[] b){
        //         return a[0]-b[0];
        //     }
        // });
        // int n = intervals.length;
        // List<int[]> response = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     int start = intervals[i][0];
        //     int end = intervals[i][1];
        //     //skipping the elements through the array already scanned
        //     if(!response.isEmpty() && end<=response.get(response.size()-1)[1]){
        //         continue;
        //     }
        //     for(int j=i+1;j<n;j++){
        //         if(intervals[j][0]<=end){
        //             end = Math.max(end, intervals[j][1]);
        //         }else{
        //             break;
        //         }
        //     }
        //     response.add(new int[]{start, end});
        // }
        // return response.toArray(new int[response.size()][]);
        
    }
}