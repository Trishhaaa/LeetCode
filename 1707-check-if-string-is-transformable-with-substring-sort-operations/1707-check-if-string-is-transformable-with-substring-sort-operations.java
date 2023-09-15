class Solution {
    public boolean isTransformable(String s, String t) {
        ArrayList<Integer> index[]= new ArrayList[10];
        int pos[]= new int[10];
        for(int i=0;i<10;i++){
            index[i]=new ArrayList<>();
        }
        for(int i=0;i<s.length();i++){
            index[s.charAt(i)-'0'].add(i);
        }
        for(int i=0;i<t.length();i++){
            int d= t.charAt(i)-'0';
            if(pos[d]>=index[d].size()){
                return false;
            }
            for(int j=0;j<d;j++){
                if(pos[j]<index[j].size() && index[j].get(pos[j])<index[d].get(pos[d])){
                    return false;
                }
            }
            pos[d]++;
        }
        return true;
    }
}