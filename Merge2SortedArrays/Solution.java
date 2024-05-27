import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        int i=0;
        int j=0;
        int m  = a.length;
        int n  =b.length;
        List<Integer> union = new ArrayList<>();
        while(i<m && j<n){
            if(a[i]<=b[j]){
                if(union.contains(a[i])){
                    i++;
                    continue;
                }
                union.add(a[i]);
                i++;
            }
            else{
                if(union.contains(b[j])){
                    j++;
                    continue;
                }
                union.add(b[j]);
                j++;
            }
        }
        while(i<m){
            if(union.contains(a[i])){
                i++;
                continue;
            }
            union.add(a[i]);
            i++;
        }
        while(j<n){
            if(union.contains(b[j])){
                j++;
                continue;
            }
            union.add(b[j]);
            j++;
        }
        return union;
    }
}
