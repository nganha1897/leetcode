class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 1;
        dp[0][0] = true;
        for (int i=1; i<n; i++) {
            dp[i][i] = true;
            ans++;
            for (int j=i-1; j>=0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i-1 == j) {
                        ans++;
                        //System.out.println(j + " " + i);
                        dp[j][i] = true;
                    }
                    else if(dp[j+1][i-1]) {
                        ans++;
                        //System.out.println(j + " " + i);
                        dp[j][i] = true;
                    }
                }
            }
        }
        return ans;
    }
}