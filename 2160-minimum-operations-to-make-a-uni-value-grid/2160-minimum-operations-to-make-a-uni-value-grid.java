class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list= new ArrayList<>();
        for(int[] row: grid){
            for(int n:row){
                list.add(n);
            }
        }
        Collections.sort(list);

        for(int n: list){
            if(Math.abs(n-list.get(0))%x!=0){
                return -1;
            }
        }
        int median=list.get(list.size()/2);
        int op=0;

        for(int n:list){
            op+=Math.abs(n-median)/x;
        }
        return op;
    }
}