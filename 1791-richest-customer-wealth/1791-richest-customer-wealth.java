class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=0;
        int currSum;

        for(int i=0;i<accounts.length;i++){
            currSum=0;
            for(int j=0;j<accounts[0].length;j++){
                
                currSum+=accounts[i][j];
                if(max<currSum){
                    max=currSum;
                }
            }
        }
        return max;
        
    }
}