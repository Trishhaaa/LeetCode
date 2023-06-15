class Solution {
    public int findDuplicate(int[] nums) {
        //sort the array
        int ans=nums.length;
        int i=0;
        while(i<nums.length){
                int correct=nums[i]-1;
                if(nums[i]!=nums[correct]){
                    swap(nums,i,correct);
                }
                else{
                    i++;
                }
        }
        for (int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                ans=nums[j];
            }
        }
        return ans;
    }
    static void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;

    }
}