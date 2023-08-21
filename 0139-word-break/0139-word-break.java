class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set= new HashSet<>(wordDict);
        Map<Integer, Boolean> map= new HashMap<>();
        return canBreak(s, 0, set, map);
    }

    private boolean canBreak(String s, int start, Set<String> set, Map<Integer, Boolean> map){
        if(start==s.length()){
            return true;
        }
        if(map.containsKey(start)){
            return map.get(start);
        }
        for(int end=start+1;end<=s.length();end++){
            if(set.contains(s.substring(start,end)) && canBreak(s,end, set, map)){
                map.put(start,true);
                return true;
            }
        }
        map.put(start,false);
        return false;

    }
}