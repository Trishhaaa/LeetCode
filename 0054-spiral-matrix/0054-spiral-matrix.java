class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans= new ArrayList<>();
        if(matrix.length==0){
            return ans;
        }

        int m=matrix.length;
        int n=matrix[0].length;

        int r1=0;
        int c1=0;
        int r2=m-1;
        int c2=n-1;

        while(ans.size()<m*n){
            for(int j=c1;j<=c2 && ans.size()<m*n;j++){
                ans.add(matrix[r1][j]);
            }
            for(int j=r1+1;j<=r2-1 && ans.size()<m*n;j++){
                ans.add(matrix[j][c2]);
            }
            for(int j=c2;j>=c1 && ans.size()<m*n;j--){
                ans.add(matrix[r2][j]);
            }
            for(int j=r2-1;j>=r1+1 && ans.size()<m*n;j--){
                ans.add(matrix[j][c1]);
            }
            ++r1;
            ++c1;
            --r2;
            --c2;
        }
        return ans;
    }
}