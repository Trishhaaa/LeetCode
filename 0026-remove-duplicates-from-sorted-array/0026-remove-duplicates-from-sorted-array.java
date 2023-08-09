class Solution {
    public int removeDuplicates(int[] nums) {
        int unique=1;

        if(nums.length==0){
            return 0;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[unique]=nums[i];
                unique++;
            }
        }
        return unique;
    }
}