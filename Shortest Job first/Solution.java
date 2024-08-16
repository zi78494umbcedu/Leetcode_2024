//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.solve(a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int solve(int bt[] ) {
    Arrays.sort(bt);
    int len =bt.length;
    int waitTime = 0;
    int avgWaitTime=0;
    for(int i=0;i<len-1;i++){
        waitTime+=bt[i];
        avgWaitTime+=waitTime;
    }
    return avgWaitTime/len;
    
  }
}
     
     
     /** 1 2 3 4 7
     0
     1
     1+2
     1+2+3
     1+2+3+4
     1+3+6+10
     */
     
