class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] ans = new int[m][n];
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                ans[r][c] = Math.min(rowSum[r], colSum[c]);
                rowSum[r] -= ans[r][c];
                colSum[c] -= ans[r][c];
            }
        }
        return ans;
    }
}