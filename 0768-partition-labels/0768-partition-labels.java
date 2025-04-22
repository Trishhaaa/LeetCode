class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastIndex= new HashMap<>();
        for(int i=0;i<s.length();i++){
            lastIndex.put(s.charAt(i),i);
        }
        int partEnd=0, partStart=0;
        List<Integer> partSizes= new ArrayList<>();
        for(int i=0;i<s.length();i++){
            partEnd=Math.max(partEnd,lastIndex.get(s.charAt(i)));

            if(i==partEnd){
                partSizes.add(i-partStart+1);
                partStart=i+1;
            }
        }
        return partSizes;
    }
}