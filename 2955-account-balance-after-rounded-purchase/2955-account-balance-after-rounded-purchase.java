class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int n=purchaseAmount%10;
        int x=10-n;

        return n>=5?Math.abs(100-(purchaseAmount+x)):Math.abs(100-(purchaseAmount-n));
        
    }
}