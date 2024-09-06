class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int[] dir = { 0, 1, 0, -1 };

        for (int r = 0, d = 0, c = 0, total = 0; total < m*n;) {
            ans.add(matrix[r][c]);
            matrix[r][c] = 101;
            if (++total == m*n) {
                return ans;
            }
            int nextR = r + dir[d];
            int nextC = c + dir[(d + 1) % 4];

            while (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || matrix[nextR][nextC] == 101) {
                d = (d + 1) % 4;
                nextR = r + dir[d];
                nextC = c + dir[(d + 1) % 4];
            }
            r = nextR;
            c = nextC;
        }

        return ans;
    }
}