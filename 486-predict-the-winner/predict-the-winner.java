class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i=0; i<n; i++) {
            dp[i] = nums[i];
        }
        for (int i=n-1; i>=0; i--) {
            int[] curDp = new int[n];
            curDp[i] = nums[i];
            for (int j=i+1; j<n; j++) {
                curDp[j] = Math.max(nums[i] - dp[j], nums[j] - curDp[j-1]);
            }
            dp = curDp;
        }
        return dp[n-1] >= 0;
    }
}