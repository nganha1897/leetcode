class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n+1];
        int max = 0;
        long ans = 0L;

        for (int num : nums) {
            max = Math.max(num, max);
        }
        for (int i=0; i<n; i++) {
            pre[i+1] = pre[i];
            if (nums[i] == max) {
                pre[i+1]++; 
            }
        }

        int l = 0, r = 0;
        while (r < n) {
            while (l <= r && pre[r+1] - pre[l] >= k) {
                ans += n - r;
                l++;
            }
            while (r < n && pre[r+1] - pre[l] < k)
                r++;
            if (r == n)
                return ans;
            ans += n - r;
            l++;
        }
        return ans;
    }
}