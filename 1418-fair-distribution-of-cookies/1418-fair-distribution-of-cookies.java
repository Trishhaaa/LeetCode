class Solution {
  int result=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
      dfs(cookies,0,k,new int[k]);
      return result;
    }
    void dfs(int[] cookies, int cur, int k, int[] children){
      if(cur==cookies.length){
        int max=0;
        for(int c:children){
          max=Math.max(max,c);
        }
        result=Math.min(result,max);
        return;
      }
      for(int i=0;i<k;i++){
        children[i]+=cookies[cur];
        dfs(cookies,cur+1,k,children);
        children[i]-=cookies[cur];
      }
    }
}