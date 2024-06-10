class Solution {
    public int heightChecker(int[] heights) {
        int[] old= heights.clone();
        Arrays.sort(heights);
        int count=0;
        for(int i=0;i<heights.length;i++){
            if(old[i]!=heights[i]){
                count++;
            }
        }
        return count;
    }
}