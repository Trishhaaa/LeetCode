class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap <Character, Integer> mapS=new HashMap<>();
        HashMap<Character, Integer> mapT= new HashMap<>();

        for(char i: s.toCharArray()){
            if(mapS.containsKey(i)){
                mapS.put(i,mapS.get(i)+1);
            }
            else{
                mapS.put(i,1);
            }
        }  
        for(char i: t.toCharArray()){
            if(mapT.containsKey(i)){
                mapT.put(i,mapT.get(i)+1);
            }
            else{
                mapT.put(i,1);
            }
        } 
        return mapS.equals(mapT);                                                       
    }
}