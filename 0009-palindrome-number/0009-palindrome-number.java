class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int rev= reverse(x);
        return rev==x;
    }
    static int reverse(int n){
        int r;
        int rev=0;
        while(n!=0){
            r=n%10;
            rev=rev*10+r;
            n=n/10;
        }

        return rev;
    }
}