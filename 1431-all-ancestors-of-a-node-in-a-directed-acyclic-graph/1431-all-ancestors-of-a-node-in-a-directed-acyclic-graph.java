class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Set<Integer>> ancestors = new ArrayList<>();
        
        // Initialize the graph and ancestors list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            ancestors.add(new HashSet<>());
        }
        
        // Build the graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        // Perform DFS for each node
        for (int i = 0; i < n; i++) {
            dfs(i, i, graph, ancestors);
        }
        
        // Convert sets to sorted lists
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> sortedAncestors = new ArrayList<>(ancestors.get(i));
            Collections.sort(sortedAncestors);
            result.add(sortedAncestors);
        }
        
        return result;
    }
    
    private void dfs(int start, int node, List<List<Integer>> graph, List<Set<Integer>> ancestors) {
        for (int neighbor : graph.get(node)) {
            if (ancestors.get(neighbor).add(start)) {
                dfs(start, neighbor, graph, ancestors);
            }
        }
    }
}