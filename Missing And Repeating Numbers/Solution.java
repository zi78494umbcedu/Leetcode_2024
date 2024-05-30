import java.util.HashMap;

public class Solution {
    public static int[] findMissingRepeatingNumbers(int []a) {
        int n=a.length;
        //using xor method
        //1.find xor of elements
        //2.find 1st set bit
        //3.divide 0 and 1 elements
        //4.from 1->N xor 0s and 1s elements to get the elements
        //5.verify which is repeated by iterating over for count
        int xor = 0;
        for(int i=0;i<n;i++){
            xor = xor ^ a[i];
            xor=xor^(i+1);
        }
        //System.out.println(xor);
        //finding the unset bit
        int bitNo=0;
        while(true){
            if((xor & (1<<bitNo))!=0){
                break;
            }
            bitNo++;
        }
        //System.out.println(bitNo);
        int ones=0;
        int zeroes=0;
        for(int i=0;i<n;i++){
            if((a[i] & (1<<bitNo))!=0){
                ones^=a[i];
            }else{
                zeroes^=a[i];
            }
        }
        for(int i=1;i<=n;i++){
            if((i & (1<<bitNo))!=0){
                ones^=i;
            }else{
                zeroes^=i;
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(a[i]==zeroes)cnt++; 
        }
        //System.out.println(zeroes+":"+ones);
        if(cnt==2){
            return new int[]{zeroes, ones};
        }
        return new int[]{ ones, zeroes};

    //     int repeating = findRepeat(a,n);
    //    int missing = findMissingNumber(a,n);
    //    return new int[]{repeating, missing^repeating};
    }

    static int findRepeat(int[] a, int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(a[i]))return a[i];
            map.put(a[i], map.getOrDefault(a[i], 0)+1);
        }
        return -1;
    }

    static int findMissingNumber(int[] arr, int n){
        int xor=n;
        for(int i=0;i<n;i++){
            xor = xor^arr[i]^i;
        }
        return xor;
    }
}
