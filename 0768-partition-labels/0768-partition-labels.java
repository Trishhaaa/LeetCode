class Solution {
    public List<Integer> partitionLabels(String s) {
       List<Integer> partitionSizes= new ArrayList<>();
        HashMap<Character, Integer> lastOcc= new HashMap<>();
        HashMap<Character, Integer> firstOcc= new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!firstOcc.containsKey(s.charAt(i))){
                firstOcc.put(s.charAt(i),i);
            }
        }
        for(int i=0;i<s.length();i++){
            lastOcc.put(s.charAt(i),i);
        }
        int partStart=0, partEnd=0;
        for(int i=0;i<s.length();i++){
            //if we find a new partition start
            if(partEnd<firstOcc.get(s.charAt(i))){
                partitionSizes.add(partEnd-partStart+1);
                partStart=i;
                partEnd=i;
            }
            //update the partition boundaries
            partEnd= Math.max(partEnd,lastOcc.get(s.charAt(i))); 
        }
        //add the last partition if it exists
        if(partEnd-partStart+1>0){
                partitionSizes.add(partEnd-partStart+1);
        }
        return partitionSizes; 
    }
}