class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low=1;
        long min=ranks[0];
        for(int i=1;i<ranks.length;i++){
            if(min>ranks[i]){
                min=ranks[i];
            }
        }

        long high=min*cars*cars;

        while(low<high){
            long mid=(low+high)/2;
            if(canRepairAll(ranks,cars,mid)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
        
    }
    private boolean canRepairAll(int[] ranks, int cars, long time){
        int totalRepaired=0;
        for(int rank: ranks){
            totalRepaired+=Math.sqrt(time/rank);
            if(totalRepaired>=cars){
                return true;
            }
        }
        return false;
    }
}