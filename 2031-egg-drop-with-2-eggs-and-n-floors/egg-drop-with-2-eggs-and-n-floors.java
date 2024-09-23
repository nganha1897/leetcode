class Solution {
    public int twoEggDrop(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i=2; i<=n; i++) {
            dp[i] = i;
            for (int j=1; j<=i; j++) {
                dp[i] = Math.min(dp[i], 1 + Math.max(j-1, dp[i-j]));
            }
        }    
        return dp[n];
    }

}