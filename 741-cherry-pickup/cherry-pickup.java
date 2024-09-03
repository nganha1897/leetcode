class Solution {
    // public int cherryPickup(int[][] grid) {
    // int n = grid.length;
    // int[][][] dp = new int[n][n][n];

    // for (int r1=0; r1<n; r1++) {
    // for (int c1=0; c1<n; c1++) {
    // for (int r2=0; r2<=r1+c1; r2++) {
    // if (r1 == 0 && c1 == 0 && r2 == 0) {
    // dp[r1][c1][r2] = grid[0][0];
    // continue;
    // }
    // int c2 = r1 + c1 - r2;
    // if (r1 > 0) {
    // if (r2 > 0) {

    // }
    // }
    // }
    // }
    // }
    // }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];
        int ans = pickup(grid, n, 0, 0, 0, dp);
        return ans == -1 ? 0 : ans;
    }

    private int pickup(int[][] grid, int n, int r1, int c1, int r2, Integer[][][] dp) {
        int c2 = r1 + c1 - r2;
        if (r1 < 0 || r1 == n || r2 < 0 || r2 == n || c1 < 0 || c1 == n || c2 < 0 || c2 == n) {
            return -1;
        }
        if (dp[r1][c1][r2] != null) {
            return dp[r1][c1][r2];
        }

        if (r1 == n-1 && c1 == n-1) {
            dp[r1][c1][r2] = grid[r1][c1];
            return dp[r1][c1][r2];
        }

        
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            dp[r1][c1][r2] = -1;
            return -1;
        }
        if (r1 == r2 && c1 == c2) {
            int o1 = pickup(grid, n, r1 + 1, c1, r2 + 1, dp);
            int o2 = pickup(grid, n, r1, c1 + 1, r2 + 1, dp);
            int o3 = pickup(grid, n, r1 + 1, c1, r2, dp);
            int o4 = pickup(grid, n, r1, c1 + 1, r2, dp);
            dp[r1][c1][r2] = Math.max(o1, Math.max(o2, Math.max(o3, o4)));
            if (dp[r1][c1][r2] != -1) {
                dp[r1][c1][r2] += grid[r1][c1];
            }
            return dp[r1][c1][r2];
        }

        int o1 = pickup(grid, n, r1 + 1, c1, r2 + 1, dp);
        int o2 = pickup(grid, n, r1, c1 + 1, r2 + 1, dp);
        int o3 = pickup(grid, n, r1 + 1, c1, r2, dp);
        int o4 = pickup(grid, n, r1, c1 + 1, r2, dp);
        dp[r1][c1][r2] = Math.max(o1, Math.max(o2, Math.max(o3, o4)));
        if (dp[r1][c1][r2] != -1) {
            dp[r1][c1][r2] += grid[r1][c1];
            dp[r1][c1][r2] += grid[r2][c2];
        }
        return dp[r1][c1][r2];
    }
}