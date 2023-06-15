class Solution {
    public int[] findErrorNums(int[] nums) {
        //sort the array
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
        //get the duplicate and missing values
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                return new int[] {nums[j], j+1};
            }

        }
        return new int[] {-1,-1};
    }
    static void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}