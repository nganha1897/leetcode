class Solution {
    public int minCapability(int[] nums, int k) {
        int ans = (int)1e9, n = nums.length, lo = 1, hi = ans;
        while (lo < hi) {
            int m = lo + (hi - lo) / 2;
            int count = 0;
            for (int i=0; i<n;) {
                if (nums[i] <= m) {
                    count++;
                    i+=2;
                } else {
                    i++;
                }
            }
            if (count >= k) {
                hi = m;
            } else
                lo = m+1;
        }
        return lo;
    }
}