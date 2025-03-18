class Solution {
    public int longestNiceSubarray(int[] nums) {
        int used=0; 
        int ans=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            while((used & nums[i])!=0){
                used^=nums[j++];
            }
            used|=nums[i];
            ans=Math.max(ans, i-j+1);
        }
        return ans;
    }
}