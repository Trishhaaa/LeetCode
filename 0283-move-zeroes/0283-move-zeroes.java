class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==0 || nums==null){
            return;
        }

        int index=0;
        for(int n:nums){
            if(n!=0){
                nums[index]=n;
                index++;
            }
        }

        while(index<nums.length){
            nums[index]=0;
            index++;
        }
        
    }
}