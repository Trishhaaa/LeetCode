class Solution {
    public void sortColors(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int last=arr.length-i-1;
            int start=0;
            int maxIndex=getMaxIndex(arr,start,last);
            swap(arr,maxIndex,last);
        }
    }

    private int getMaxIndex(int[] arr, int start, int last){
        int max=start;
        for(int i=start;i<=last;i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }

    private void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}