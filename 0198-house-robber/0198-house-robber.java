class Solution {
    public int rob(int[] nums) {
        Integer[] memo= new Integer[nums.length];
        return robHouses(nums,0,memo);
    }

    private int robHouses(int[] nums, int i, Integer[] memo){
        if(i>=nums.length){
            return 0;
        }
        if(memo[i]!=null){
            return memo[i];
        }

        int skipCurrent=robHouses(nums, i+1,memo);
        int robCurrent=nums[i]+robHouses(nums,i+2,memo);

        memo[i]=Math.max(skipCurrent, robCurrent);

        return memo[i];
    }
}