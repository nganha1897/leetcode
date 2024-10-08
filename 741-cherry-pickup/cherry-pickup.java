class Solution {
    // public int cherryPickup(int[][] grid) {
    //     int n = grid.length;
    //     int[][][] dp = new int[n][n][n];

    //     for (int r1 = 0; r1 < n; r1++) {
    //         for (int c1 = 0; c1 < n; c1++) {
    //             Arrays.fill(dp[r1][c1], -1);
    //             for (int r2 = 0; r2 <= r1 + c1 && r2 < n; r2++) {
                    
    //                 if (r1 == 0 && c1 == 0 && r2 == 0) {
    //                     dp[r1][c1][r2] = grid[0][0];
    //                     continue;
    //                 }
    //                 int c2 = r1 + c1 - r2;
    //                 if (c2 < 0 || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
    //                     dp[r1][c1][r2] = -1;
    //                     continue;
    //                 }
                    
    //                 dp[r1][c1][r2] = -1;

    //                 if (r1 > 0) {
    //                     dp[r1][c1][r2] = Math.max(dp[r1][c1][r2], dp[r1 - 1][c1][r2]);
    //                     if (r2 > 0) {
    //                         dp[r1][c1][r2] = Math.max(dp[r1][c1][r2], dp[r1 - 1][c1][r2 - 1]);
    //                     }
    //                 }
    //                 if (c1 > 0) {
    //                     dp[r1][c1][r2] = Math.max(dp[r1][c1][r2], dp[r1][c1 - 1][r2]);
    //                     if (r2 > 0) {
    //                         dp[r1][c1][r2] = Math.max(dp[r1][c1][r2], dp[r1][c1 - 1][r2 - 1]);
    //                     }
    //                 }

    //                 if (dp[r1][c1][r2] == -1)
    //                     continue;

    //                 dp[r1][c1][r2] += grid[r1][c1];
    //                 if (r1 != r2 || c1 != c2) {
    //                     dp[r1][c1][r2] += grid[r2][c2];
    //                 }
    //                 //System.out.println(r1 + " " + r2 + " " + c1 + " " + c2 + " " + dp[r1][c1][r2]);
    //             }
    //         }
    //     }
    //     return dp[n - 1][n - 1][n - 1] == -1 ? 0 : dp[n-1][n-1][n-1];
    // }


    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][] dp = new int[N][N];
        for (int[] row: dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        dp[0][0] = grid[0][0];

        for (int t = 1; t <= 2*N - 2; ++t) {
            int[][] dp2 = new int[N][N];
            for (int[] row: dp2) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }

            for (int i = Math.max(0, t - (N - 1)); i <= Math.min(N - 1, t); ++i) {
                for (int j = Math.max(0, t - (N - 1)); j <= Math.min(N - 1, t); ++j) {
                    if (grid[i][t - i] == -1 || grid[j][t - j] == -1) {
                        continue;
                    }                    
                    int val = grid[i][t-i];
                    if (i != j) {
                        val += grid[j][t - j];
                    }
                    for (int pi = i - 1; pi <= i; ++pi) {
                        for (int pj = j - 1; pj <= j; ++pj) {
                            if (pi >= 0 && pj >= 0) {
                                dp2[i][j] = Math.max(dp2[i][j], dp[pi][pj] + val);
                            }
                        }
                    }
                }
            }
            dp = dp2;
        }
        return Math.max(0, dp[N - 1][N - 1]);
    }

    // public int cherryPickup(int[][] grid) {
    // int n = grid.length;
    // Integer[][][] dp = new Integer[n][n][n];
    // int ans = pickup(grid, n, 0, 0, 0, dp);
    // return ans == -1 ? 0 : ans;
    // }

    // private int pickup(int[][] grid, int n, int r1, int c1, int r2, Integer[][][]
    // dp) {
    // int c2 = r1 + c1 - r2;
    // if (r1 < 0 || r1 == n || r2 < 0 || r2 == n || c1 < 0 || c1 == n || c2 < 0 ||
    // c2 == n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
    // return -1;
    // }
    // if (dp[r1][c1][r2] != null) {
    // return dp[r1][c1][r2];
    // }

    // if (r1 == n-1 && c1 == n-1) {
    // dp[r1][c1][r2] = grid[r1][c1];
    // return dp[r1][c1][r2];
    // }

    // if (r1 == r2 && c1 == c2) {
    // int o1 = pickup(grid, n, r1 + 1, c1, r2 + 1, dp);
    // int o2 = pickup(grid, n, r1, c1 + 1, r2 + 1, dp);
    // int o3 = pickup(grid, n, r1 + 1, c1, r2, dp);
    // int o4 = pickup(grid, n, r1, c1 + 1, r2, dp);
    // dp[r1][c1][r2] = Math.max(o1, Math.max(o2, Math.max(o3, o4)));
    // if (dp[r1][c1][r2] != -1) {
    // dp[r1][c1][r2] += grid[r1][c1];
    // }
    // return dp[r1][c1][r2];
    // }

    // int o1 = pickup(grid, n, r1 + 1, c1, r2 + 1, dp);
    // int o2 = pickup(grid, n, r1, c1 + 1, r2 + 1, dp);
    // int o3 = pickup(grid, n, r1 + 1, c1, r2, dp);
    // int o4 = pickup(grid, n, r1, c1 + 1, r2, dp);
    // dp[r1][c1][r2] = Math.max(o1, Math.max(o2, Math.max(o3, o4)));
    // if (dp[r1][c1][r2] != -1) {
    // dp[r1][c1][r2] += grid[r1][c1];
    // dp[r1][c1][r2] += grid[r2][c2];
    // }
    // return dp[r1][c1][r2];
    // }
}