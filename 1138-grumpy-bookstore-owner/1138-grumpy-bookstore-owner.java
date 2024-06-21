class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int baselineSatisfaction = 0;
        
        // Calculate baseline satisfaction
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                baselineSatisfaction += customers[i];
            }
        }
        
        // Calculate the maximum additional satisfaction we can get by using the technique
        int additionalSatisfaction = 0;
        int currentWindowSatisfaction = 0;
        
        // Initial window calculation
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentWindowSatisfaction += customers[i];
            }
        }
        
        additionalSatisfaction = currentWindowSatisfaction;
        
        // Slide the window over the remaining elements
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                currentWindowSatisfaction += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                currentWindowSatisfaction -= customers[i - minutes];
            }
            additionalSatisfaction = Math.max(additionalSatisfaction, currentWindowSatisfaction);
        }
        
        return baselineSatisfaction + additionalSatisfaction;
    }
}