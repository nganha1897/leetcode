class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if(exist(board, r, c, 0, word, visited))
                    return true;
                visited = new boolean[m][n];
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int r, int c, int p, String word, boolean[][] visited) {
        if (p == word.length()) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]) {
            return false;
        }
        visited[r][c] = true;
        if (board[r][c] == word.charAt(p)) {
            if (exist(board, r+1, c, p+1, word, visited)) {
                return true;
            }
            if (exist(board, r, c+1, p+1, word, visited)) {
                return true;
            }
            if (exist(board, r-1, c, p+1, word, visited)) {
                return true;
            }
            if (exist(board, r, c-1, p+1, word, visited)) {
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }
}