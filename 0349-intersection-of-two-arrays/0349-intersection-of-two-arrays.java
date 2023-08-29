class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1= new HashSet<>();
        for(int num:nums1){
            set1.add(num);
        }
        HashSet<Integer> set2= new HashSet<>();
        for(int num:nums2){
            set2.add(num);
        }
        if(set1.size()<set2.size()){
            return setIntersection(set1,set2);
        }
        return setIntersection(set2,set1);
        
    }

    private int[] setIntersection(HashSet<Integer> set1, HashSet<Integer> set2){
        int[] result= new int[set1.size()];
        int index=0;
        for(Integer i: set1){
            if(set2.contains(i)){
                result[index]=i;
                index++;
            }
        }

        return Arrays.copyOf(result,index);
    }

}