class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
         Map<Integer, Integer> originalIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            originalIndex.put(nums[i], i);
        }

        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> {
                    int mappedA = getMappedValue(a, mapping);
                    int mappedB = getMappedValue(b, mapping);
                    if (mappedA == mappedB) {
                        return originalIndex.get(a) - originalIndex.get(b);
                    } else {
                        return Integer.compare(mappedA, mappedB);
                    }
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }
    // Function to map a number based on the mapping array
    private static int getMappedValue(int num, int[] mapping) {
        StringBuilder mappedNumber = new StringBuilder();
        String numStr = Integer.toString(num);
        for (char digit : numStr.toCharArray()) {
            mappedNumber.append(mapping[digit - '0']);
        }
        // Remove leading zeros
        return Integer.parseInt(mappedNumber.toString());
    }
}