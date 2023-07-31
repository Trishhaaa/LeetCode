class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> ans= new LinkedList<List<Integer>>();


        for(int i=0;i<nums.length-2;i++){
            if(i==0||(i>0 && nums[i]!=nums[i-1])){
                int target= 0- nums[i];
                int left=i+1;
                int right=nums.length-1;
                
                while(left<right){

                if(nums[left]+nums[right]==target){
                    ArrayList<Integer> list= new ArrayList<>();

                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);

                    ans.add(list);

                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }

                    left++;
                    right--;
                }

                else if(nums[left]+nums[right]<target){
                    left++;
                }
                else{
                    right--;
                }
                }
            }
        }
        return ans;
    }
}