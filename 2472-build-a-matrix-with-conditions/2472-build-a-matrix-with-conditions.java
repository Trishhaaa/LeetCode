class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer>[] rowGraph = new ArrayList[k + 1];
        List<Integer>[] colGraph = new ArrayList[k + 1];
        int[] rowIndegree = new int[k + 1];
        int[] colIndegree = new int[k + 1];

        for (int i = 1; i <= k; i++) {
            rowGraph[i] = new ArrayList<>();
            colGraph[i] = new ArrayList<>();
        }

        for (int[] condition : rowConditions) {
            rowGraph[condition[0]].add(condition[1]);
            rowIndegree[condition[1]]++;
        }

        for (int[] condition : colConditions) {
            colGraph[condition[0]].add(condition[1]);
            colIndegree[condition[1]]++;
        }

        List<Integer> rowOrder = topologicalSort(rowGraph, rowIndegree, k);
        List<Integer> colOrder = topologicalSort(colGraph, colIndegree, k);

        if (rowOrder.size() < k || colOrder.size() < k) {
            return new int[0][0]; // Cycle detected or not all nodes are connected
        }

        int[][] result = new int[k][k];
        int[] rowPosition = new int[k + 1];
        int[] colPosition = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowPosition[rowOrder.get(i)] = i;
            colPosition[colOrder.get(i)] = i;
        }

        for (int i = 1; i <= k; i++) {
            result[rowPosition[i]][colPosition[i]] = i;
        }

        return result;
    }

    private List<Integer> topologicalSort(List<Integer>[] graph, int[] indegree, int k) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : graph[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return order;
    }   
    
}