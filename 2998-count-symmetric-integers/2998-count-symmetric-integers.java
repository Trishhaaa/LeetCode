class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int n=low;n<=high;n++){
            String s=Integer.toString(n);
            if(s.length()%2!=0){
                continue;
            }
            int mid= s.length()/2;
            int left=0, right=0;
            for(int i=0;i<mid;i++){
                left+=s.charAt(i)+'0';
                right+=s.charAt(mid+i)+'0';
            }
            if(left==right){
                count++;
            }
        }
        return count;
    
    }
}