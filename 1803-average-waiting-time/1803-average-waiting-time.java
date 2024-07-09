class Solution {
    public double averageWaitingTime(int[][] customers) {
        int currTime=0;
        double totalWait=0.0;

        for(int[] customer: customers){
            int arrival=customer[0];
            int prepTime=customer[1];

            currTime=Math.max(arrival, currTime);
            currTime+=prepTime;

            int wait=currTime-arrival;
            totalWait+=wait;
        }

        double avg= totalWait/customers.length;
        return avg;
    }
}