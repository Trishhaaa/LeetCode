class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
       int n = difficulty.length;
        int[][] jobs = new int[n][2];
        
        // Step 1: Create job array with difficulty and profit
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        // Step 2: Sort jobs by difficulty
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        // Step 3: Sort workers by their ability
        Arrays.sort(worker);
        
        int maxProfit = 0;
        int jobIndex = 0;
        int bestProfit = 0;
        
        // Step 4: Assign the best possible job to each worker
        for (int ability : worker) {
            // While the worker can do the job, update the best profit
            while (jobIndex < n && jobs[jobIndex][0] <= ability) {
                bestProfit = Math.max(bestProfit, jobs[jobIndex][1]);
                jobIndex++;
            }
            maxProfit += bestProfit;
        }
        
        return maxProfit; 
    }
}