class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // Initializing with 0 to handle edge cases
        int currentOddCount = 0;
        int result = 0;

        for (int num : nums) {
            if (num % 2 == 1) {
                currentOddCount++;
            }
            if (prefixCount.containsKey(currentOddCount - k)) {
                result += prefixCount.get(currentOddCount - k);
            }
            prefixCount.put(currentOddCount, prefixCount.getOrDefault(currentOddCount, 0) + 1);
        }

        return result;
    }
}