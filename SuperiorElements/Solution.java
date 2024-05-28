import java.util.*;
public class Solution {
    public static List< Integer > superiorElements(int []a) {
        //optimal approach
        int n = a.length;
        int max =Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            if(a[i]>max){
                result.add(a[i]);
            }
            max= Math.max(max, a[i]);
        }
        return result;
        //brute force O(n^2);
        // Set<Integer> ans = new HashSet<>();
        // int n=a.length;
        // for(int i=0;i<n-1;i++){
        //     boolean superior = true;
        //     for(int j=i+1;j<n;j++){
        //         if(a[i]<a[j]){
        //             superior=false;
        //             break;
        //         }
        //     }
        //     if(superior==true){ans.add(a[i]);}
        // }
        // ans.add(a[n-1]);
        // List<Integer> res = new ArrayList<>();
        // res.addAll(ans);
        // Collections.sort(res);
        // return res;
    }
}
