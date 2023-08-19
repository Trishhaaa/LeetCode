class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result= 0;
        int diff=Integer.MAX_VALUE;

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int currSum= nums[i]+nums[left]+nums[right];
                int newdiff=Math.abs(currSum-target);
                if(newdiff<diff){
                    result=currSum;
                    diff=newdiff;
                }

                if(currSum<target)
                    left++;
                else
                    right--;
            }
        }
        return result;
    }
}