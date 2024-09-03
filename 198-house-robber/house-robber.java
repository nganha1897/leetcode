class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        int max = nums[0];
        for (int i=1; i<n; i++) {
            max = Math.max(nums[i] + prev2, prev);
            prev2 = prev;
            prev = max;
        }
        return max;
    }
}