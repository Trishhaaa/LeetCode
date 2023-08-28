class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] tails = new int[n];
        int length = 1;
        
        tails[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            if (nums[i] > tails[length - 1]) {
                tails[length] = nums[i];
                length++;
            } else {
                int index = binarySearch(tails, 0, length - 1, nums[i]);
                tails[index] = nums[i];
            }
        }
        
        return length;
    }
    
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}