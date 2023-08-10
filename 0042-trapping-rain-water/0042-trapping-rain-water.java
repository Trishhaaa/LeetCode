class Solution {
    public int trap(int[] height) {
        if(height.length<=2){
            return 0;
        }
        int n=height.length;
        int trapped=0;
        int left=0;
        int right=n-1;
        int leftMax=0;
        int rightMax=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>leftMax){
                    leftMax=height[left];
                }
                else{
                    trapped+=leftMax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>rightMax){
                    rightMax=height[right];
                }
                else{
                    trapped+=rightMax-height[right];
                }
                right--;
            }
        }

        return trapped;
    }
}