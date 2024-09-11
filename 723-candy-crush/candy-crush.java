class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean canCrush = crush(board, m, n);

        while (canCrush) {
            drop(board, m, n);
            canCrush = crush(board, m, n);
        }

        return board;
    }

    private boolean crush(int[][] board, int m, int n) {
        boolean canCrush = false;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] != 0) {
                    int val = Math.abs(board[r][c]);
                    if (c+2 < n && val == Math.abs(board[r][c+1]) && val == Math.abs(board[r][c+2])) {
                        board[r][c] = board[r][c+1] = board[r][c+2] = -val;
                        canCrush = true;
                    }
                    if (r+2 < m && val == Math.abs(board[r+1][c]) && val == Math.abs(board[r+2][c])) {
                        board[r][c] = board[r+1][c] = board[r+2][c] = -val;
                        canCrush = true;
                    }
                }
            }
        }
        return canCrush;
    }

    private void drop(int[][] board, int m, int n) {
        for (int c=0; c<n; c++) {
            int empty = 0;
            for (int r=m-1; r>=0; r--) {
                if (board[r][c] < 0) {
                    board[r][c] = 0;
                    empty++;
                } else {
                    if (empty > 0) {
                        board[r + empty][c] = board[r][c];
                        board[r][c] = 0;
                    }
                }
            }
        }
    }
}