class Solution {
    public int partitionString(String s) {
        int[] lastSeen= new int[26];
        Arrays.fill(lastSeen,-1);

        int count=1;
        int start=0;

        for(int i=0;i<s.length();i++){
            if(lastSeen[s.charAt(i)-'a']>=start){
                count++;
                start=i;
            }
            lastSeen[s.charAt(i)-'a']=i;
        }

        return count;
        
    }
}