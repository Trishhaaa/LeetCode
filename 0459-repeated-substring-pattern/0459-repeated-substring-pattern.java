class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int len =1;len<=s.length()/2;len++){
            if(s.length()%len==0){
                String sub=s.substring(0,len);
                String str="";

                for(int i=0;i<s.length()/len;i++){
                    str+=sub;
                }
                if(str.equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}