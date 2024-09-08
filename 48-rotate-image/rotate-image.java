class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int r=0; r<=(n-1)/2; r++) {
            for (int c=r; c<n-1-r; c++) {
                rotate(matrix, n, r, c);
            }
        }
    }
    private void rotate(int[][] matrix, int n, int r, int c) {
        int prev = matrix[r][c];
        for (int i=0; i<4; i++) {
            int nextR = c;
            int nextC = n - 1 - r;
            int temp = matrix[nextR][nextC];
            matrix[nextR][nextC] = prev;
            prev = temp;
            r = nextR;
            c = nextC;
        }
    }
}