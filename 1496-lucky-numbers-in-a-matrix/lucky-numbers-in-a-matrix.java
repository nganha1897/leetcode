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

            int max = min;
            int maxRow = 0;
            boolean isMaxCol = true;
            for (int curR=0; curR<m; curR++) {
                if (matrix[curR][minCol] > max) {
                    isMaxCol = false;
                    break;
                }
            }

            if (isMaxCol)
                ans.add(max);
        }

        return ans;
    }
}