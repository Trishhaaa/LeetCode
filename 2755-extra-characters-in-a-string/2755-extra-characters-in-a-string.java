class Solution {
    int[] memo;
    HashSet<String> set;
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        memo=new int[n];

        Arrays.fill(memo,-1);

        set=new HashSet<>();

        for(int i=0;i<dictionary.length;i++){
            set.add(dictionary[i]);
        }

        return recursive(0,n,s);
    }

    private int recursive(int start, int n, String s){
        if(start==n){
            return 0;
        }
        if(memo[start]!=-1){
            return memo[start];
        }

        int ans= recursive(start+1,n,s)+1;

        for(int end=start;end<n;end++){
            String curr=s.substring(start,end+1);
            if(set.contains(curr)){
                ans=Math.min(ans, recursive(end+1,n,s));
            }
        }
        memo[start]=ans;
        return ans;
    }
}