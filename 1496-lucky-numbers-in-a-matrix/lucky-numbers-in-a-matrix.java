class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        for (int r=0; r<m; r++) {
            int min = matrix[r][0];
            int minCol = 0;
            for (int c=0; c<n; c++) {
                if (matrix[r][c] < min) {
                    min = matrix[r][c];
                    minCol = c; 
                }
            }

            int max = matrix[0][minCol];
            int maxRow = 0;
            for (int curR=0; curR<m; curR++) {
                if (matrix[curR][minCol] > max) {
                    max = matrix[curR][minCol];
                    maxRow = curR;
                }
            }

            if (r == maxRow)
                ans.add(matrix[r][minCol]);
        }

        return ans;
    }
}