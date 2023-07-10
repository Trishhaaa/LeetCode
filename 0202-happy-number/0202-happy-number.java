class Solution {
    public boolean isHappy(int n) {
        int fast=n;
        int slow=n;
        do{
            slow=findSquare(slow);
            fast=findSquare(findSquare(fast));
        }while(slow!=fast);
        if(slow==1){
            return true;
        }
        else{
            return false;
        }
    }
    static int findSquare(int num){
        int ans=0;
        while(num>0){
            int r= num%10;
            num=num/10;
            ans+=r*r;
        }
        return ans;
    }
}