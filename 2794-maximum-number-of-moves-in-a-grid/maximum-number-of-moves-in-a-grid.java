class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length, max = 0;
        int[][] dp = new int[n][m];
        //System.out.println(m + " " + n);

        Arrays.fill(dp[0], 1);
        for (int c=1; c<n; c++) {
            for (int r=0; r<m; r++) {    
                dp[c][r] = (grid[r][c-1] < grid[r][c] ? dp[c-1][r] : 0);
                if (r > 0) {
                    dp[c][r] = Math.max(dp[c][r], (grid[r-1][c-1] < grid[r][c] ? dp[c-1][r-1] : 0));
                }
                if (r < m - 1) {
                    dp[c][r] = Math.max(dp[c][r], (grid[r+1][c-1] < grid[r][c] ? dp[c-1][r+1] : 0));
                }
                if (dp[c][r] > 0)
                    dp[c][r]++;
                max = Math.max(max, dp[c][r]);
            }
        }
        
        for (int r=0; r<m; r++) {
            max = Math.max(max, dp[n-1][r]);
        }
        return (max > 0 ? max - 1 : 0);
    }
}