class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1; // The smallest number that we can't form
        int patches = 0; // Number of patches added
        int i = 0; // Index to iterate over nums
        
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // If the current number in nums is less than or equal to miss, use it to extend the range
                miss += nums[i];
                i++;
            } else {
                // If the current number in nums is greater than miss, patch the array with miss
                miss += miss;
                patches++;
            }
        }
        
        return patches;
    }
}