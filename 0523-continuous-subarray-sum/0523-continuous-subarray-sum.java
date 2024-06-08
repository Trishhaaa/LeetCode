class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
         // Map to store the first occurrence of the modulo value
        Map<Integer, Integer> modMap = new HashMap<>();
        // Initialize with mod 0 at index -1 to handle edge cases
        modMap.put(0, -1);
        int cumulativeSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            // If k is not 0, take modulo k of the cumulative sum
            if (k != 0) {
                cumulativeSum %= k;
            }
            
            // Check if this modulo value was seen before
            if (modMap.containsKey(cumulativeSum)) {
                // Check the length of the subarray
                if (i - modMap.get(cumulativeSum) > 1) {
                    return true;
                }
            } else {
                // Store the index of the first occurrence of this modulo value
                modMap.put(cumulativeSum, i);
            }
        }
        
        return false;
        
    }
}