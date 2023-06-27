class Solution {
    public int trailingZeroes(int n) {
        int count=0;
        if(n<5){
            return 0;
        }
        //number is decreased exponentially
        while(n>4){
           n=n/5;
           count+=n;
        }
        return count;
    }
}