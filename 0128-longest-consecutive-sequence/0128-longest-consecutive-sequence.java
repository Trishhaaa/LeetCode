class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0||nums.length==1){
            return nums.length;
        }
        HashSet<Integer> set= new HashSet<>();
        int ans=1;
        for(int num: nums){
            set.add(num);
        }

        for(int num: nums){
            if(!set.contains(num-1)){
                int count=1;
                while(set.contains(num+1)){
                    count++;
                    num++;
                }

                ans= Math.max(ans, count);
            }
        }

        return ans;
    }
}