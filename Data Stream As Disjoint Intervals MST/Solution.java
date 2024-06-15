import java.util.*;

public class Solution {

    public static class DisjointIntervals {
        public TreeMap<Integer, Integer> intervals;

        public DisjointIntervals() {
            intervals = new TreeMap<>();
        }

        public void addInteger(int val) {
            Integer floorKey = intervals.floorKey(val);
            Integer ceilingKey = intervals.ceilingKey(val);

            // Check if val merges with the interval ending at floorKey
            if (floorKey != null && intervals.get(floorKey) >= val-1) {
                int end = intervals.get(floorKey);
                intervals.remove(floorKey);
                intervals.put(floorKey, Math.max(end, val));
            } else if (ceilingKey != null && ceilingKey == val + 1) {
                // Check if val merges with the interval starting at ceilingKey
                int end = intervals.get(ceilingKey);
                intervals.remove(ceilingKey);
                intervals.put(val, end);
            } else {
                // Create a new interval [val, val]
                intervals.put(val, val);
            }
        }

        public List<List<Integer>> getDisjointIntervals() {
            List<List<Integer>> result = new ArrayList<>();
            for (int start : intervals.keySet()) {
                int end = intervals.get(start);
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);
                result.add(temp);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        DisjointIntervals disjointIntervals = new DisjointIntervals();
        disjointIntervals.addInteger(1);
        disjointIntervals.addInteger(11);
        disjointIntervals.addInteger(8);
        disjointIntervals.addInteger(6);
        disjointIntervals.addInteger(7);
        disjointIntervals.addInteger(4);
        disjointIntervals.addInteger(6);
        disjointIntervals.addInteger(11);
        disjointIntervals.addInteger(2);

        List<List<Integer>> intervals = disjointIntervals.getDisjointIntervals();
        for (List<Integer> interval : intervals) {
            System.out.print(interval.get(0) + " " + interval.get(1) + " ");
        }
        System.out.println();
    }
}
