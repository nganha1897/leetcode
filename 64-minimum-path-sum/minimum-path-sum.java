class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int r=m-1; r>=0; r--) 
            for (int c=n-1; c>=0; c--) 
                    if (r + 1 < m && c + 1 < n) {
                        grid[r][c] += Math.min(grid[r+1][c], grid[r][c+1]);
                    } else if (r + 1 < m) {
                        grid[r][c] += grid[r+1][c];
                    } else if (c + 1 < n) {
                        grid[r][c] += grid[r][c+1];
                    }

        return grid[0][0];
    }
}