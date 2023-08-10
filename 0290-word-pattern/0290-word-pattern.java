class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str= s.split(" ");
        HashMap<Character, String> charToWord= new HashMap<>();
        HashMap<String, Character> wordToChar= new HashMap<>();

        if(pattern.length()!=str.length){
            return false;
        }

        for(int i=0;i<pattern.length();i++){
            char c=pattern.charAt(i);
            String word= str[i];

            if(charToWord.containsKey(c)){
                if(!charToWord.get(c).equals(word)){
                    return false;
                }
            }
            else{
                charToWord.put(c, word);
            }

            if(wordToChar.containsKey(word)){
                if(wordToChar.get(word)!=c){
                    return false;
                }

            }
            else{
                wordToChar.put(word,c);
            }
        }

        return true;
    }
}