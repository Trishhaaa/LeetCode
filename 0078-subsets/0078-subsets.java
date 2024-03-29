class Solution {
    List<List<Integer>> result= new ArrayList<>();
    int n, k;

    public List<List<Integer>> subsets(int[] nums) {
        n=nums.length;
        for(k=0;k<n+1;k++){
            backtrack(0,new ArrayList<>(), nums);
        }

        return result;
    }

    private void backtrack(int first, List<Integer> curr, int[] nums){
        if(curr.size()==k){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=first;i<n;i++){
            curr.add(nums[i]);
            backtrack(i+1,curr, nums);
            curr.remove(curr.size()-1);
        }
    }
}