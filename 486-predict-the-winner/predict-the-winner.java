class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        return predict(nums, 0, n-1, new int[n][n]) >= 0;
    }

    private int predict(int[] nums, int st, int e, int[][] dp) {
        if (st > e) {
            return 0;
        }

        if (dp[st][e] != 0) {
            return dp[st][e];
        }

        int pickFirst = predict(nums, st+1, e, dp);
        int pickLast = predict(nums, st, e-1, dp);
        // if ((e - st + 1) % 2 == nums.length % 2) {
        //     dp[st][e] = Math.max(nums[st] - pickFirst, nums[e] - pickLast);
        // } else {
        //     dp[st][e] = Math.max(pickFirst - nums[st], pickLast - nums[e]);
        // }
        dp[st][e] = Math.max(nums[st] - pickFirst, nums[e] - pickLast);
        //System.out.println(st + " " + e + " " + dp[st][e]);
        return dp[st][e];
    }
}