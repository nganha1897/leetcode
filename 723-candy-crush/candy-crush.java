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
                    int curR = r, curC = c, count = 0;
                    while (curC < n && (board[r][curC] == val || board[r][curC] == -val)) {
                        count++;
                        curC++;
                    }
                    if (count >= 3) {
                        curC = c;
                        canCrush = true;
                        while (curC < n && (board[r][curC] == val || board[r][curC] == -val)) {
                            board[r][curC++] = -val;
                        }
                    }
                    count = 0;
                    curC = c;
                    while (curR < m && (board[curR][c] == val || board[curR][c] == -val)) {
                        count++;
                        curR++;
                    }
                    if (count >= 3) {
                        curR = r;
                        canCrush = true;
                        while (curR < m && (board[curR][c] == val || board[curR][c] == -val))  {
                            board[curR++][c] = -val;
                        }
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