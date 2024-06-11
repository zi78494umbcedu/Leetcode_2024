import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;


class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}

public class Solution {
    public static int minimumOperations(int n, int start, int end, int []a) {
        //dijkstra's with normal queue since unit steps
        //O(10^3 * n)
        Queue<Pair> q = new LinkedList<>();
        int mod= 1000;
        if(start>mod || end>mod)return -1;
        if(start==end)return 0;
        int[] distance = new int[mod];
        Arrays.fill(distance,(int)(1e9));
        distance[start]=0;
        //node/currrent multiplication factor, multiplication times
        q.add(new Pair(start, 0));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int num  = temp.first;
            int times= temp.second;
            for(int number:a){
                int newNum = (number*num)%mod;
                if((times+1)<distance[newNum]){
                    distance[newNum]=times+1;
                    if(newNum==end)return times+1;
                    q.add(new Pair(newNum, times+1));
                }
            }
        }
        return -1;
    }
}
