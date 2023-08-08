class Solution {
    public int search(int[] arr, int target) {
        int start=0;
        int end= arr.length-1;
        int mid;

        while(start<=end){
            mid= (start+end)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(target<arr[mid]){
                end=end-1;
            }
            else{
                start= start+1;
            }
        }
        return -1;
    }
}