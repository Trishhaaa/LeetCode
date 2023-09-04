class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result= new ArrayList<>();
        Map<String, Integer> map= new HashMap<>();

        for(int i=0;i<=s.length()-10;i++){
            String seq=s.substring(i,i+10);
            if(!map.containsKey(seq)){
                map.put(seq,1);
            }
            else{
                map.put(seq,map.get(seq)+1);
            }

        }

        for(Map.Entry<String, Integer> entry:map.entrySet()){
            if(entry.getValue()>1){
                result.add(entry.getKey());
            }
        }

        return result;
    }
}