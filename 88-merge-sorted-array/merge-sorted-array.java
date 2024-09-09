class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, pos = m + n - 1;
        
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    nums1[pos--] = nums1[i--];
                } else {
                    nums1[pos--] = nums2[j--];
                }
            } else if (i >= 0) 
                return;
            else {
                nums1[pos--] = nums2[j--];
            }
        }
    }
}