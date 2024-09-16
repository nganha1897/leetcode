class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                dp[i] = false;
            } else {
                if (nums[i] <= nums[i + 1]+1) {
                    dp[i] = dp[i + 1];
                } else {
                    if (dp[i + 1] || nums[i] + i >= n - 1) {
                        dp[i] = true;
                    } else {
                        for (int j = nums[i] + i; j >= nums[i+1] + i+1; j--) {
                            if (j >= n) {
                                dp[i] = true;
                                break;
                            }
                            if (dp[j]) {
                                dp[i] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}