class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        char [] j= jewels.toCharArray();
        char[] s= stones.toCharArray();
        int count=0;

        for(char stone: s){
            for(char jewel: j){
                if(stone==jewel){
                    count++;
                }
            }
        }
        return count;

    }
}