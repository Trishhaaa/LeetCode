class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        Integer[][] memo= new Integer[m][n];

        return findPaths(0,0,m, n, obstacleGrid,memo);
    }

    private int findPaths(int i, int j, int m, int n, int[][] obstacleGrid, Integer[][] memo){
        if(i>=m || j>=n ||obstacleGrid[i][j]==1){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }

        int pathsRight=findPaths(i,j+1,m,n,obstacleGrid,memo);
        int pathsDown=findPaths(i+1,j,m,n,obstacleGrid,memo);

        memo[i][j]=pathsRight+pathsDown;

        return memo[i][j];
    }
}