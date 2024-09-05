class Solution {
    // public int maxCoins(int[] nums) {
    // int ans = 0;
    // int[] newNums = new int[nums.length+2];
    // int n = 1;
    // for (int x : nums) {
    // newNums[n++] = x;
    // }
    // newNums[0] = newNums[n++] = 1;
    // int[][] dp = new int[n][n];

    // for (int i = n-2; i>=1; i--) {
    // for (int j = i; j < n-1; j++) {
    // for (int k=i; k<=j; k++) {
    // int gain = newNums[i-1] * newNums[k] * newNums[j+1];
    // int remaining = dp[i][k-1] + dp[k+1][j];
    // dp[i][j] = Math.max(dp[i][j], gain + remaining);

    // }
    // }
    // }
    // return dp[1][n-2];
    // }

    public int maxCoins(int[] nums) {
        int ans = 0;
        int[] newNums = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) {
            newNums[n++] = x;
        }
        newNums[0] = newNums[n++] = 1;
        int[][] dp = new int[n][n];
        return maxCoins(newNums, 1, n-2, dp);
    }

    private int maxCoins(int[] nums, int left, int right, int[][] dp) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right] > 0) {
            return dp[left][right];
        }

        for (int i = left; i <= right; i++) {
            int gain = nums[left - 1] * nums[i] * nums[right + 1];
            int remaining = maxCoins(nums, left, i - 1, dp) + maxCoins(nums, i + 1, right, dp);
            dp[left][right] = Math.max(dp[left][right], gain + remaining);
        }
        return dp[left][right];
    }
}