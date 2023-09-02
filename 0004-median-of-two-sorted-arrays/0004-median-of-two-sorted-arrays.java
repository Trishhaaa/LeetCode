class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr=merge(nums1,nums2);
        int n=arr.length;
        if(n%2==0){
            return (double)(arr[n/2-1]+arr[n/2])/2;
        }
        return arr[n/2];
        
    }

    private int[] merge(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] mergedArray = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        // Compare elements from both arrays and merge them
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k] = arr1[i];
                i++;
            } else {
                mergedArray[k] = arr2[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements from arr1 (if any)
        while (i < n1) {
            mergedArray[k] = arr1[i];
            i++;
            k++;
        }

        // Copy the remaining elements from arr2 (if any)
        while (j < n2) {
            mergedArray[k] = arr2[j];
            j++;
            k++;
        }

        return mergedArray;
    }
}