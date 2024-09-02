class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;

        int maxMinRow = 0;
        for (int r = 0; r < m; r++) {
            int min = matrix[r][0];
            for (int c = 0; c < n; c++) {
                min = Math.min(min, matrix[r][c]);
            }
            maxMinRow = Math.max(maxMinRow, min);
        }

        int minMaxCol = 100001;
        for (int c = 0; c < n; c++) {
            int max = matrix[0][c];
            for (int r = 0; r < m; r++) {
                max = Math.max(max, matrix[r][c]);
            }
            minMaxCol = Math.min(minMaxCol, max);
        }

        if (maxMinRow == minMaxCol) {
            ans.add(maxMinRow);
        }
        return ans;
    }
}