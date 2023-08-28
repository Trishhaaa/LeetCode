class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] memo= new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }

        return calculate(grid,0,0,memo);
    }

    private int calculate(int[][] grid, int row, int col, int[][] memo){
        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }

        if(memo[row][col]!=-1){
            return memo[row][col];
        }

        int rightPathSum=col<grid[0].length-1? calculate(grid,row,col+1,memo):Integer.MAX_VALUE;
        int downPathSum=row<grid.length-1?calculate(grid, row+1, col, memo):Integer.MAX_VALUE;

        memo[row][col]=grid[row][col]+Math.min(rightPathSum, downPathSum);

        return memo[row][col];
    }
}