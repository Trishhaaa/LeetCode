class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result= new int[nums.length-k+1];
        Deque<Integer> deque=new ArrayDeque<>();
        int resultIdx=0;
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty() && deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(i>=k-1){
                result[resultIdx++]=nums[deque.peekFirst()];
            }
        }

        return result;
    }
}