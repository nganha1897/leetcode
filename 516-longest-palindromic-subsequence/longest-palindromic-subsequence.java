class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i=n-1; i>=0; i--) {
            int[] curDp = new int[n];
            curDp[i] = 1;
            for (int j=i+1; j<n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    curDp[j] = 2 + dp[j-1];
                }
                curDp[j] = Math.max(Math.max(curDp[j], curDp[j-1]), dp[j]);
            }
            dp = curDp;
        }
        return dp[n-1];
    }
}