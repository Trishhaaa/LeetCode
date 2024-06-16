class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
         PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxProfitHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // Add projects to minCapitalHeap
        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }

        // Iterate through k projects
        for (int i = 0; i < k; i++) {
            // Add feasible projects to maxProfitHeap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            // No projects available
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // Select project with maximum profit and update capital
            w += maxProfitHeap.poll()[1];
        }

        return w;
    }
}