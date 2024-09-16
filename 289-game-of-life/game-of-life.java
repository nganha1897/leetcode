class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] dir = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 },
                { 0, -1 } };
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int live = 0;
                for (int d = 0; d < dir.length; d++) {
                    int nextR = r + dir[d][0];
                    int nextC = c + dir[d][1];
                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n) {
                        live += (board[nextR][nextC] == 1 || board[nextR][nextC] == -1) ? 1 : 0;
                    }
                }
                if (board[r][c] == 1) {
                    if (live < 2 || live > 3) {
                        board[r][c] = -1;
                    }
                } else {
                    if (live == 3) {
                        board[r][c] = 2;
                    }
                }
            }
        }

        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (board[r][c] == -1) {
                    board[r][c] = 0;
                } else if (board[r][c] == 2) {
                    board[r][c] = 1;
                }
            }
        }
    }
}