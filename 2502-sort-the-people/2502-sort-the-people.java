class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map= new HashMap<>();

        for(int i=0;i<heights.length;i++){
            map.put(heights[i],names[i]);
        }

        sortDescending(heights);

        String[] result= new String[names.length];

        for(int i=0;i<heights.length;i++){
            result[i]=map.get(heights[i]);
        }
        return result;
    }
    public static void sortDescending(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped, the array is already sorted
            if (!swapped) break;
        }
    }
}