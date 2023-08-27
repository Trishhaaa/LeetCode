class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> jumpMap= new HashMap<>();
        int n=stones.length;

        for(int stone:stones){
            jumpMap.put(stone, new HashSet<>());
        }

        jumpMap.get(0).add(0);

        for(int i=0;i<n;i++){
            for(int jumpSize:jumpMap.get(stones[i])){
                for(int k=jumpSize-1;k<=jumpSize+1;k++){
                    if(k>0 && jumpMap.containsKey(stones[i]+k)){
                        jumpMap.get(stones[i]+k).add(k);
                    }
                }
            }
        }

        return !jumpMap.get(stones[n-1]).isEmpty();
        
    }
}