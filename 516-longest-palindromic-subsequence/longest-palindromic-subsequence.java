class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];

        for (int i=n-1; i>=0; i--) {
            dp[i] = 1;
            int prev = 0;
            for (int j=i+1; j<n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = 2 + prev;
                } else 
                    dp[j] = Math.max(dp[j], dp[j-1]);
                prev = temp;
            }
        }
        return dp[n-1];
    }

    // public int longestPalindromeSubseq(String s) {
    //     int n = s.length();
    //     int[][] memo = new int[n][n];
    //     return lps(s, 0, n - 1, memo);
    // }

    // private int lps(String s, int i, int j, int[][] memo) {
    //     if (memo[i][j] != 0) {
    //         return memo[i][j];
    //     }
    //     if (i > j) {
    //         return 0;
    //     }
    //     if (i == j) {
    //         return 1;
    //     }

    //     if (s.charAt(i) == s.charAt(j)) {
    //         memo[i][j] = lps(s, i + 1, j - 1, memo) + 2;
    //     } else {
    //         memo[i][j] = Math.max(lps(s, i + 1, j, memo), lps(s, i, j - 1, memo));
    //     }
    //     return memo[i][j];
    // }
}