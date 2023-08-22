class Solution {
    public String convertToTitle(int columnNumber) {
        String result="";
        while(columnNumber>0){
            columnNumber--;
            int rem=columnNumber%26;
            char digit=(char)('A'+rem);
            result=digit+result;
            columnNumber/=26;
        }

        return result;
    }
}