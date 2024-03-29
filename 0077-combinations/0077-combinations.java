class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result= new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1,n,k);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> curr, int start, int n, int k){
        if(k==0){
            result.add(new ArrayList<> (curr));
            return;
        }

        for(int i=start;i<=n;i++){
            curr.add(i);
            backtrack(result, curr, i+1,n,k-1);
            curr.remove(curr.size()-1);
        }
    }
}