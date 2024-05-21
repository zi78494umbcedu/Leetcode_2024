class Solution {
    public String getPermutation(int n, int k) {
        //optimal method
        int fact =1;
        //for storing the numbers array
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<n;i++){
            //calculating the factorial of the n-1 subarray {1, 2, 3, 4} then not 4! but 3!=6 for 1+{2, 3, 4} permutations
            fact = fact*i;
            numbers.add(i);
        }
        //adding the last integer to the array
        numbers.add(n);
        String ans = "";
        //since starting with 0 indexing
        k=k-1;
        while(true){
            //k/fact for lets say k=16, 16/6 since n-1! here is 6 for list of 3 numbers, then 16/6~ @index 2 lies the ans 1+{2, 3, 4}==0-5, 2+{1, 3, 4}==6-11, 3+{1, 2, 4}==12-16, 4+{1, 2, 3}==17-23 in this case, 16/6
            ans = ans+ numbers.get(k/fact);
            //for recursively finding the next number, now the list is {1, 2, 4 } since 3 is removed, for the ans lies in that group of permutations
            numbers.remove(k/fact);
            //base case
            if(numbers.size()==0){
                break;
            }
            //adjust k and fact
            //fact => divide by the size of the numbers array since 3! then 2! and so
            //k => k%fact since from 16th index requirement -> 16/6 has 6 possibilities, then as numbers.size goes down, 2 possibilities i.e., fact. Possible position out of the permutations
            k=k%fact;
            fact = fact/numbers.size();
        }
        return ans;
    }

        //brute force recursion
        // int fact = n*(n+1)/2;
        // List<String> permutations = new ArrayList<>();
        // int[] nums = new int[n];
        // for(int i=1;i<=n;i++){
        //     nums[i-1] = i;
        // }
        // recursivePermutations(0, permutations, nums);
        // String[] sorted = new String[permutations.size()];
        // for(int i=0;i<permutations.size();i++){
        //     sorted[i]= permutations.get(i);
        // }
        // Arrays.sort(sorted);
        // return sorted[k-1];

    static void recursivePermutations(int ind, List<String> list, int[] nums){
        if(ind==nums.length){
            String tempString = "";
            for(int i=0;i<nums.length;i++){
                tempString+=String.valueOf(nums[i]);
            }
            list.add(tempString);
            return;
        }
        for(int i=ind;i<nums.length;i++){
            swap(i, ind, nums);
            recursivePermutations(ind+1, list, nums);
            swap(i, ind, nums);
        }
    }
    static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}