import java.util.*;
public class Solution {
public static class DisjointIntervals {
        public Set<Integer> h;
        public DisjointIntervals() {
            h=new TreeSet<>();
        }
        public void addInteger(int val) {
             h.add(val);
        }
        public List<List<Integer>> getDisjointIntervals() {
        List<List<Integer>> ans=new ArrayList<>();
            Iterator<Integer> it=h.iterator();
            int start=0,end=0,prev=0;
            if(it.hasNext()){
              start=it.next();
              prev=start;
            }
            while(it.hasNext()){
                 int curr=it.next();
                 if(curr!=prev+1){
                  end=prev;
                  ans.add(Arrays.asList( start,end));
                  start=curr;
                }
                prev=curr;
            }
        ans.add(Arrays.asList(start,prev));
        return ans;
      }
    }
}
