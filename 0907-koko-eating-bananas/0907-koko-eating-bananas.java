class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //initializa the left and right boundaries

        int left=1;
        int right=1;

        for(int pile: piles){
            right= Math.max(right,pile);
        }

        while(left<right){
            int mid= (left+right)/2;
            int hourSpent=0;

            for(int pile:piles){
                hourSpent+=Math.ceil((double) pile/mid);
            }

            if(hourSpent<=h){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }

        return right;
    }
}