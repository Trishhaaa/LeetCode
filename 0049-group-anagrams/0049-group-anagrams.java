class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams= new ArrayList<>();
        HashMap<String, List<String>> map= new HashMap<>();

        for(String str: strs){
            char []arr=str.toCharArray();
            Arrays.sort(arr);
            String newstr= new String(arr);

            if(map.containsKey(newstr)==false){
                map.put(newstr, new ArrayList<>());
            }
            map.get(newstr).add(str);
        }
        anagrams.addAll(map.values());
        return anagrams;
    }
}