class Solution {
    public int numTeams(int[] rating) {
         int n = rating.length;
        int count = 0;
        
        for (int j = 1; j < n - 1; j++) {
            int leftSmaller = 0, leftGreater = 0, rightSmaller = 0, rightGreater = 0;
            
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftSmaller++;
                } else if (rating[i] > rating[j]) {
                    leftGreater++;
                }
            }
            
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) {
                    rightSmaller++;
                } else if (rating[k] > rating[j]) {
                    rightGreater++;
                }
            }
            
            count += leftSmaller * rightGreater + leftGreater * rightSmaller;
        }
        
        return count;
    }
}