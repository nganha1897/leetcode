class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = i-j+1;
                for (int k = j; k < i; k++) {
                    dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i] + (s.charAt(k) == s.charAt(i) ? -1 : 0));
                }

            }
        }
        return dp[0][n - 1];
    }
}