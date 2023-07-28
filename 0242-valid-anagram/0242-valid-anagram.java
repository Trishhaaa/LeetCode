class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Integer> charCountS= new HashMap<>();
        HashMap<Character, Integer> charCountT= new HashMap<>();

        for(char charS: s.toCharArray()){
            if(charCountS.containsKey(charS)){
                charCountS.put(charS, charCountS.get(charS)+1);
            }
            else{
                charCountS.put(charS, 1);
            }
        }

        for(char charT: t.toCharArray()){
            if(charCountT.containsKey(charT)){
                charCountT.put(charT, charCountT.get(charT)+1);
            }
            else{
            charCountT.put(charT,1);
            }
        }
        return charCountS.equals(charCountT);
    }
}