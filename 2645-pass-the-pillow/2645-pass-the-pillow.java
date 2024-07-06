class Solution {
    public int passThePillow(int n, int time) {
        int cycle=2*(n-1);
        int effTime=time%cycle;
        if(effTime<n){
            return 1+effTime;
        }
        return (cycle-effTime)+1;
    }
}