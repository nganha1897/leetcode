class Solution {
    public long appealSum(String s) {
        int[] dp = new int[s.length()+1];
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        long ans = 0;
        
        for (int i=0; i<s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            if (pos[cur] != -1) {
                dp[i+1] = dp[i] + i - pos[cur];
            }
            else 
                dp[i+1] = dp[i] + i + 1;
            pos[cur] = i;
            ans += dp[i+1];
        }
        
        return ans;
    }
}