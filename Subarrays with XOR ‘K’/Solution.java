import java.util.HashMap;

public class Solution {
    public static int subarraysWithSumK(int []a, int b) {
        // //brute force n^2
        // int n=a.length;
        // int count=0;
        // for(int i=0;i<n;i++){
        //     int xor=0;
        //     for(int j=i;j<n;j++){
        //         xor=xor^a[j];
        //         if(xor==b){
        //             count++;
        //         }
        //     }
        // }
        // return count;
        //better approach
        int xor=0;
        int count=0;
        int n = a.length;
        //xor, i
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<n;i++){
            xor ^=a[i];
            int reqXor = xor^b;
            if(map.containsKey(reqXor)){
                count += map.get(reqXor);
            }
            map.put(xor, map.getOrDefault(xor, 0)+1);
            
        }
        return count++;
    }
}
