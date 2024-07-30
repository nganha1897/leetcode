class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int r=m-1; r>=0; r--) {
            for (int c=n-1; c>=0; c--) {
                if (r == m-1 && c==n-1)
                    dp[c] = grid[r][c];
                else
                    dp[c] = grid[r][c] + Math.min(dp[c], dp[c+1]);
            }
        }

        return dp[0];
    }
}