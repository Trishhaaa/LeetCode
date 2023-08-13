class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> curr, int[] nums){
        if(curr.size()==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int num: nums){
            if(curr.contains(num)){
                continue;
            }
            curr.add(num);
            backtrack(result, curr, nums);
            curr.remove(curr.size()-1);
        }
    }
}