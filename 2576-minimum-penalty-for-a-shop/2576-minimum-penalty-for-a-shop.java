class Solution {
    public int bestClosingTime(String customers) {
        int len=customers.length();
        int Y=0;
        for(int i=0;i<len;i++){
            Y+=customers.charAt(i)=='Y'?1:0;
        }
        int min_p=len;
        int hour=len;

        int y_found=0;
        int n_found=0;

        for(int i=0;i<=len;i++){
            int y_remaining=Y-y_found;
            int pen=y_remaining+n_found;

            if(pen<min_p){
                hour=i;
                min_p=pen;
            }

            if(i<len&& customers.charAt(i)=='N'){
                n_found++;
            }
            if(i<len && customers.charAt(i)=='Y'){
                y_found++;
            }
        }
        return hour;
        
    }
}