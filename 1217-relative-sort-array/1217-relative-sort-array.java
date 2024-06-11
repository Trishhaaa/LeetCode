class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a list to store the sorted result
        List<Integer> result = new ArrayList<>();

        // Step 3: Add elements from arr2 based on the count in arr1
        for (int num : arr2) {
            int count = countMap.get(num);
            for (int i = 0; i < count; i++) {
                result.add(num);
            }
            countMap.remove(num);  // Remove the element from the map once processed
        }

        // Step 4: Collect remaining elements and sort them
        List<Integer> remaining = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remaining.add(num);
            }
        }
        Collections.sort(remaining);

        // Step 5: Add the sorted remaining elements to the result
        result.addAll(remaining);

        // Convert result list to array
        int[] resultArray = result.stream().mapToInt(i -> i).toArray();
        return resultArray;
    }
}