class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        //create an array of size 26 for every letter.
        int[] store=new int[26];
        for(int i=0;i<s.length();i++){
            store[s.charAt(i)-'a']++;
            store[t.charAt(i)-'a']--;
        }

        //if they are anagrams, the value of each alphabet should be zero. If it is not zero, it means there are different alphabets. 
        for(int n:store){
            if(n!=0){
                return false;
            }
        }
        return true;
        
    }
}