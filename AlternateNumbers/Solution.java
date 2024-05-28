import java.util.ArrayList;

public class Solution {
    public static int[] alternateNumbers(int []a) {
        // Write your code here.
        //falling back to the brute force for covering the case when positives!=negatives in count
        // int posIndex=0;
        // int negIndex=1;
        // int n= a.length;
        // int[] pos = new int[n];
        // int[] neg = new int[n];
        // int[] result=new int[n];
        // for(int i=0;i<n;i++){
        //     if(a[i]<0){
        //         result[negIndex]=a[i];
        //         negIndex+=2;
        //     }else{
        //         result[posIndex]=a[i];
        //         posIndex+=2;
        //     }
        // }
        // return result;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n=a.length;
        //segregating pos's and neg's
        for(int i=0;i<n;i++){
            if(a[i]>0)pos.add(a[i]);
            else{neg.add(a[i]);}
        }
        //result array
        int[] ans =new int[n];
        //neg>pos
        if(neg.size()>pos.size()){
            for(int i=0;i<pos.size();i++){
                ans[2*i]=pos.get(i);
                ans[2*i+1]=neg.get(i);
            }
            //add remaining negs
            for(int i=pos.size();i<neg.size();i++){
                ans[i]=neg.get(i);
            }
        }else{
            for(int i=0;i<neg.size();i++){
                ans[2*i]=pos.get(i);
                ans[2*i+1]=neg.get(i);
            }
            //add remaining negs
            for(int i=neg.size();i<pos.size();i++){
                ans[i]=pos.get(i);
            }
        }
        return ans;
    }
}
