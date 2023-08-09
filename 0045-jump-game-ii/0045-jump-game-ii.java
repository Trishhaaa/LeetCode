class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int currEnd=0;
        int farthestJump=0;
        for(int i=0;i<nums.length-1;i++){
            farthestJump=Math.max(farthestJump,i+nums[i]);
            if(i==currEnd){
                jumps++;
                currEnd=farthestJump;
            }
        }
        return jumps;
    }
}