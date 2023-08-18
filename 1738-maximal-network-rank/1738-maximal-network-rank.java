class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] graph= new Set[n];
        for(int i=0;i<n;i++){
            graph[i]=new HashSet<>();
        }

        for(int[] road: roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        int maxRank=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int rank=graph[i].size()+graph[j].size();
                if(graph[i].contains(j)){
                    rank--;
                }
                maxRank=Math.max(rank,maxRank);
            }
        }

        return maxRank;
    }
}