class Solution {
    public boolean predictTheWinner(int[] nums) {
        Integer[][] memo= new Integer[nums.length][nums.length];

        int score=getScore(nums,0,nums.length-1,memo);
        return score>=0;
    }

    private int getScore(int[] nums, int start, int end, Integer[][]memo){
        if(start==end){
            return nums[start];
        }

        if(memo[start][end]!=null){
            return memo[start][end];
        }

        int chooseStart=nums[start]-getScore(nums,start+1,end,memo);
        int chooseEnd=nums[end]-getScore(nums,start,end-1,memo);
        
        memo[start][end]= Math.max(chooseStart, chooseEnd);

        return memo[start][end];
    }
}