class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int prefix = nums[0];
        int suffix = nums[n-1];

        for (int i=1; i<n; i++) {
            ans[i] = prefix;
            prefix *= nums[i];
        }

        ans[0] = 1;
        for (int i=n-2; i>=0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }

        return ans;
    }
}