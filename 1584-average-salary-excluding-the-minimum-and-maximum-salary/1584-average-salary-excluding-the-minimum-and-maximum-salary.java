class Solution {
    public double average(int[] s) {
        Arrays.sort(s);

        int min=s[0];
        int max=s[s.length-1];

        double sum=0;

        for(int i=1;i<s.length-1;i++){
            sum+=s[i];
        }

        return sum/(s.length-2);
    }
}