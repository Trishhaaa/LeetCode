class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans= new int[nums.length];
        ans[0]=1;
        for(int i=0;i<nums.length-1;i++){
            ans[i+1]=ans[i]*nums[i];
        }
        for(int i=nums.length-2;i>=0;i--){
            ans[i]=ans[i]*nums[i+1];
            nums[i]=nums[i]*nums[i+1];
        }
        return ans;
    }
}