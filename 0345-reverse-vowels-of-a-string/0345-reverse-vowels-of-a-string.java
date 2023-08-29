class Solution {
    public String reverseVowels(String s) {
        int start=0;
        int end=s.length()-1;
        char[] str= s.toCharArray();

        while(start<end){
            while(start<end && !isVowel(str[start])){
                start++;
            }
            while(end>=0 && !isVowel(str[end])){
                end--;
            }

            if(start<end){
                swap(str, start,end);
            }
            start++;
            end--;

        }

        return new String(str);
        
    }
    private boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }

    private void swap(char[] str, int i, int j){
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }
}