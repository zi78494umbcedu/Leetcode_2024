import java.util.*;

public class Solution {
    public static List<List<Integer>> subarraysWithSumK(int[] a, long k) {
        if(a.length==0)return new ArrayList<>();
        List<List<Integer>> subarrays = new ArrayList<>();
        Set<List<Integer>> subsets = new HashSet<>();
        recurSubs(a.length, a, 0,0, new ArrayList<>(), k, 0, subsets);
        subarrays.addAll(subsets);
        return subarrays;
    }

    static void recurSubs(int n, int[] nums, int ind, int start, List<Integer> tempList, long sum, long sumHere, Set<List<Integer>> subsets) {
        if (sumHere==sum) {
            Collections.sort(tempList);
            subsets.add(new ArrayList<>(tempList));
            return;
        }
        if (ind >= n) {
            return;
        }
        for(int i=start; i<n;i++){
            tempList.add(nums[i]);
            recurSubs(n, nums, i + 1,i+1, tempList, sum, sumHere+nums[i], subsets);
            tempList.remove(tempList.size()-1);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++; // Skip consecutive duplicates
            }
            //recurSubs(n, nums, i + 1,i+1, tempList, sum, sumHere, subsets);
        }
       
        
    }
}
