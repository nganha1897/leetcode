class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int hi = 0, lo = nums[0];
        for (int num : nums) {
            hi += num;
            lo = Math.max(lo, num);
        }

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int p = 1;
            for (int i=0, sum=0; i<n && p<=k; i++) {
                if (sum + nums[i] <= mid && n-1-i >= k-p)
                    sum += nums[i];
                else {
                    p++;
                    sum = nums[i];
                }
            }
            if (p > k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}