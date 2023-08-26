class Solution {
    public String multiply(String nums1, String nums2) {
        int len1=nums1.length();
        int len2=nums2.length();

        int[] result= new int[len1+len2];  // for the intermediate results

        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int product=(nums1.charAt(i)-'0')*(nums2.charAt(j)-'0');
                int sum=product+result[i+j+1];
                result[i+j+1]=sum%10;  //update the current digit
                result[i+j]+=sum/10;  // carry over to the next digit
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int digit:result){
            if(!(digit==0 && sb.length()==0)){
                sb.append(digit);
            }
        }
        return sb.length()==0?"0":sb.toString();

    }
}