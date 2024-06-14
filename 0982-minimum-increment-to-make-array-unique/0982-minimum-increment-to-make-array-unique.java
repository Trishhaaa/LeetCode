class Solution {
    public int minIncrementForUnique(int[] nums) {
         // Step 1: Sort the array
        Arrays.sort(nums);
        
        int moves = 0;
        int minUnique = nums[0];
        
        // Step 2: Traverse the sorted array
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= minUnique) {
                // Step 3: Increment to the next unique value
                moves += (minUnique + 1 - nums[i]);
                minUnique++;
            } else {
                minUnique = nums[i];
            }
        }
        
        return moves;
    }
}