class Solution {
    public int scoreOfString(String s) {
        int score=0;
        for(int i=0;i<s.length()-1;i++){
            char curr=s.charAt(i);
            char next=s.charAt(i+1);
            int diff=Math.abs(curr-next);
            score+=diff;
        }
        return score;
    }
}