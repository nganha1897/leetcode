class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        int[][] ans = new int[m][n];
        if (m * n != len) {
            return new int[0][0];
        }
        int pos = 0;
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                ans[r][c] = original[pos++];
            }
        }
        return ans;
    }
}