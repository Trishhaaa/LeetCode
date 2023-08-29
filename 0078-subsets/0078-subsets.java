class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        result.add(new ArrayList<>());
        
        for(int num:nums){
            List<List<Integer>> newSubsets= new ArrayList<>();
            for(List<Integer> curr: result){
                newSubsets.add(new ArrayList<>(curr){{add(num);}});
            }
            for(List<Integer> curr:newSubsets){
                result.add(curr);
            }
        }

        return result;
        
    }
}