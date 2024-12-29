class Solution {
    public int numWays(String[] words, String target) {
        int m = (int)1e9 + 7, n = words.length, t = target.length(), wordLen = words[0].length();
        long[][] dp = new long[t+1][wordLen+1];
        int[][] count = new int[wordLen][26];

        for (int j=0; j<wordLen; j++) {
            for (int i=0; i<n; i++) {
                count[j][words[i].charAt(j)-'a']++;
            }
        }
        
        for (int j=0; j<wordLen; j++) {
            dp[0][j] = 1l;
        }

        for (int i=0; i<t; i++) {
            for (int j=0; j<wordLen; j++) {
                dp[i+1][j+1] = (dp[i][j] * count[j][target.charAt(i)-'a'] + dp[i+1][j]) % m;
            }
        }

        return (int)dp[t][wordLen];
    }
}