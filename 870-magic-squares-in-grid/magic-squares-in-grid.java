class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        for (int r = 2; r < n; r++) {
            for (int c = 2; c < m; c++) {
                boolean isMagic = true;
                //System.out.println(grid[r][c]);
                int[] num = new int[10];
                for (int nr = r - 2; nr <= r; nr++) {
                    int sumRow = 0;

                    for (int nc = c - 2; nc <= c; nc++) {
                        if (grid[nr][nc] > 9) {
                            isMagic = false;
                            //System.out.println(1);
                            break;
                        } else {
                            num[grid[nr][nc]]++;
                        }
                        sumRow += grid[nr][nc];
                    }
                    if (sumRow != 15) {
                        isMagic = false;
                        //System.out.println(2 + " " + grid[r][c]);
                        break;
                    }
                }
                for (int i = 1; i < 10; i++) {
                    if (num[i] != 1) {
                        isMagic = false;
                        //System.out.println(3);
                    }
                }

                for (int nc = c - 2; nc <= c; nc++) {
                    int sumCol = 0;
                    for (int nr = r - 2; nr <= r; nr++) {
                        sumCol += grid[nr][nc];
                    }
                    if (sumCol != 15) {
                        isMagic = false;
                        //System.out.println(4);
                        break;
                    }
                }

                int backwardDiag = grid[r][c] + grid[r - 1][c - 1] + grid[r - 2][c - 2];
                if (backwardDiag != 15) {
                    isMagic = false;
                }
                int forwardDiag = grid[r][c - 2] + grid[r - 1][c - 1] + grid[r - 2][c];
                if (forwardDiag != 15) {
                    isMagic = false;
                }

                if (isMagic) {
                    ans++;
                }
            }

        }
        return ans;
    }
}