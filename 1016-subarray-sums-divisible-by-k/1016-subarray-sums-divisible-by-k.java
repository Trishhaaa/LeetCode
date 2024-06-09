class Solution {
    public int subarraysDivByK(int[] A, int K) {
         HashMap<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); // To handle the case where the prefix sum itself is divisible by K

        int prefixSum = 0;
        int count = 0;

        for (int num : A) {
            prefixSum += num;
            int remainder = prefixSum % K;

            // Adjust remainder to be non-negative
            if (remainder < 0) {
                remainder += K;
            }

            // If this remainder has been seen before, it means there are subarrays ending at the current index with sum divisible by K
            if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
            }

            // Update the count of this remainder in the hashmap
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}