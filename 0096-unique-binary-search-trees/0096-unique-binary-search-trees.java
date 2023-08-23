class Solution {
    public int numTrees(int n) {
        if(n<=0){
            return 0;
        }

        int[] memo= new int[n+1];
        return countUniqueBST(n,memo);
    }

    private int countUniqueBST(int n, int[] memo){
        if(n<=1){
            return 1;
        }
        if(memo[n]!=0){
            return memo[n];
        }

        int count=0;

        for(int i=1;i<=n;i++){
            count+=countUniqueBST(i-1,memo)*countUniqueBST(n-i,memo);
        }
        memo[n]=count;
        return memo[n];
    }
}