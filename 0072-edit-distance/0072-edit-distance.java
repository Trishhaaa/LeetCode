class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo= new int[word1.length()+1][word2.length()+1];
        return minDist(word1,word2,word1.length(),word2.length(),memo);
    }

    private int minDist(String word1, String word2, int i1, int i2,int[][] memo){
        if(memo[i1][i2]>0){
            return memo[i1][i2];
        }
        if(i1==0){
            memo[i1][i2]= i2;
        }
        else if(i2==0){
            memo[i1][i2]= i1;
        }

        else if(word1.charAt(i1-1)==word2.charAt(i2-1)){
            memo[i1][i2]= minDist(word1,word2,i1-1,i2-1,memo);
        }
        else{
        int insert=minDist(word1,word2,i1,i2-1,memo);
        int delete=minDist(word1,word2,i1-1,i2,memo);
        int replace=minDist(word1,word2,i1-1,i2-1,memo);

        memo[i1][i2]= Math.min(Math.min(insert,delete),replace)+1;
        }
        return memo[i1][i2];
    }
}