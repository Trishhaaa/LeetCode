class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] words= s.split("\\s+");
        String ans="";
        for(int i=words.length-1;i>=0;i--){
            ans+=words[i];
            if(i>0){
                ans+=" ";
            }
        }

        return ans;
    }
}