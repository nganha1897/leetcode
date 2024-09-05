class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), len = 0;
        int st=0,e=0;
        boolean[][] dp = new boolean[n+1][n+1];
        for (int i=n-1; i>=0; i--) {
            dp[i][i] = true;
            for (int j=i+1; j<n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j-1) {
                        dp[i][j] = true;
                    } else 
                        dp[i][j] = dp[i+1][j-1];
                    if (dp[i][j]) {
                        if (j-i+1 > len) {
                            len = j - i + 1;
                            st=i;
                            e=j;
                        }
                    }
                }
            }
        }
        return s.substring(st, e+1);
    }
}