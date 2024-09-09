class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        long ans = 0;
        Arrays.sort(nums);
        int n = nums.length, m = n / 2;
        if (nums[m] < k) {
            while (m < n && nums[m] < k) {
                ans += k - nums[m++];
            }
            return ans;
        } else if (nums[m] > k) {
            while (m >= 0 && nums[m] > k) {
                ans += nums[m--] - k;
            }
            return ans;
        } 
        return ans;
    }
}