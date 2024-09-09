class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, s = 0, e = 0, n = nums.length;
        int mult = 1;
        while (e < n) {
            mult *= nums[e++];
            while (s < e && mult >= k) {
                mult /= nums[s++];
            }
            if (mult < k) {
                ans += e - s;
            }
        }

        return ans;
    }
}