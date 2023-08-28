class Solution {
    private double[][] memo;
    public double soupServings(int n) {
        if(n>=5000){
            return 1;
        }

        memo=new double[n+1][n+1];
        for(double[] row: memo){
            Arrays.fill(row,-1.0);
        }

        return prob(n,n);
    }

    private double prob(int a,int b){
        if(a<=0 && b<=0){
            return 0.5;
        }
        if(a<=0){
            return 1.0;
        }
        if(b<=0){
            return 0.0;
        }

        if(memo[a][b]!=-1.0){
            return memo[a][b];
        }

        double probability=0.25*(prob(a-100,b)+prob(a-75,b-25)+prob(a-50,b-50)+prob(a-25,b-75));
        memo[a][b]=probability;
        return probability;
    }

}