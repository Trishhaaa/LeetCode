class Solution {
    Map<Integer, Integer> map= new HashMap<>();
    public int numDecodings(String s) {
        return recursive(0,s);
    }

    private int recursive(int index, String s){
        if(map.containsKey(index)){
            return map.get(index);
        }
        if(index==s.length()){
            return 1;
        }

        if(s.charAt(index)=='0'){
            return 0;
        }

        if(index==s.length()-1){
            return 1;
        }

        int ans=recursive(index+1,s);
        if(Integer.parseInt(s.substring(index,index+2))<=26){
            ans+=recursive(index+2,s);
        }
        map.put(index,ans);
        return ans;
    }

}