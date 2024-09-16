class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, 0, 0, dp);
    }

    private int dfs(String s, int i, int cur, int[] dp) {
        if (i == s.length()) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = 0;
        int c = s.charAt(i) - '0';
        if (c == 0 && (cur == 0 || cur > 2)) {
            return 0;
        }
        if (c != 0) {
            dp[i] = dfs(s, i + 1, c, dp);
            ans += dp[i];
        }
        if (cur != 0) {
            cur = cur * 10 + c;
            if (cur <= 26) {
                ans += dfs(s, i + 1, cur, dp);
            }
        }
        return ans;
    }
}