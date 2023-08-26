class Solution {
    public int uniquePaths(int m, int n) {
        long paths=1;
        for(int i=1;i<n;i++){
            paths*=(m+i-1);
            paths/=i;
        }

        return (int)paths;
    }
}