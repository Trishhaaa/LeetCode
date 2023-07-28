class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //map the sorted string to the list of anagrams
        List<List<String>> anagrams= new ArrayList<>();
        HashMap<String, List<String>> map= new HashMap<>();

        for(String str: strs){
            char[] charArray= str.toCharArray();
            Arrays.sort(charArray);
            String sorted= new String(charArray);

            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }

            //add the current string to the list
            map.get(sorted).add(str);
        }
        anagrams.addAll(map.values());
        return anagrams;
    }
}