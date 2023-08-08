class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r= nums.length-1;
        while(l<=r){
            int mid= (l+r)/2;

            if(target==nums[mid]){
                return mid;
            }
            if(nums[l]<=nums[mid]){
                if(nums[mid]<target || target<nums[l]){
                    l=mid+1;
                }
                else{
                    r= mid-1;
                }
            }
            else{
                if(nums[mid]>target || target>nums[r]){
                    r=mid-1;
                }
                else{
                    l= mid+1;
                }
            }
        }
        return -1;
    }
}