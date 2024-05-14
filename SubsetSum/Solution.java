import java.util.*;

public class Solution {
    public static boolean isSubsetPresent(int n, int k, int[] a) {
        return isSubsetPresentHelper(a, 0, k);
    }

    static boolean isSubsetPresentHelper(int[] nums, int ind, int target) {
        if (target == 0) {
            return true;  // Subset with sum equal to target found
        }
        if (ind == nums.length || target < 0) {
            return false; // Subset not found
        }

        // Include current element in the subset and recursively check if it leads to the target sum
        if (isSubsetPresentHelper(nums, ind + 1, target - nums[ind])) {
            return true;
        }

        // Exclude current element from the subset and recursively check if it leads to the target sum
        return isSubsetPresentHelper(nums, ind + 1, target);
    }
}
