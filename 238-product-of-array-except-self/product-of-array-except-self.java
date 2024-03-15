class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        right[n-1] = nums[n-1];
        for (int i=n-2; i>=0; i--) {
            right[i] = nums[i] * right[i+1];
        } 
        int left = 1;
        for (int i=0; i<n; i++) {
            if (i < n-1)
                right[i] = left * right[i+1];
            else
                right[i] = left;
            left *= nums[i];
        }
        return right;
    }
}