class Solution {
    public char findTheDifference(String s, String t) {
        char[] S=s.toCharArray();
        char[] T= t.toCharArray();

        Arrays.sort(S);
        Arrays.sort(T);
        int i=0;

        for( i=0;i<s.length();i++){
            if(S[i]!=T[i]){
                return T[i];
            }
        }
        return T[i];
    }
}