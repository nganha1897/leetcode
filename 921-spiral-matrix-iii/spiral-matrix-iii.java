// class Solution {
//     public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
//         int[][] ans = new int[rows * cols][];
//         int[] move = new int[] { 0, 1, 0, -1 };
//         boolean[][] visited = new boolean[rows][cols];
//         for (int r = rStart, c = cStart, pos = 0, m = 0; pos < rows * cols;) {
//             System.out.println(r + " " + c);
//             if (!visited[r][c]) {
//                 visited[r][c] = true;
//                 ans[pos++] = new int[] { r, c };
//             }
//             while (visited[r][c] && pos < rows * cols) {
//                 int nextM = (m + 1) % 4;
//                 while (r + move[m] < 0 || r + move[m] == rows || c + move[((m + 1) % 4)] < 0
//                         || c + move[((m + 1) % 4)] == cols || (r + move[nextM] >= 0 && r + move[nextM] < rows && c + move[((nextM + 1) % 4)] >= 0 && c + move[((nextM + 1) % 4)] < cols && !visited[r+move[nextM]][c+move[((m + 1) % 4)]])) {
//                     m = (m + 1) % 4;
//                 }
//                 r += move[m];
//                 c += move[(m + 1) % 4];
//             }
//         }
//         return ans;
//     }
// }

class Solution {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // Store all possible directions in an array.
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] traversed = new int[rows * cols][2];
        int idx = 0;

        // Initial step size is 1, value of d represents the current direction.
        for (int step = 1, direction = 0; idx < rows * cols;) {
            // direction = 0 -> East, direction = 1 -> South
            // direction = 2 -> West, direction = 3 -> North
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < step; ++j) {
                    // Validate the current position
                    if (
                        rStart >= 0 &&
                        rStart < rows &&
                        cStart >= 0 &&
                        cStart < cols
                    ) {
                        traversed[idx][0] = rStart;
                        traversed[idx][1] = cStart;
                        ++idx;
                    }
                    // Make changes to the current position.
                    rStart += dir[direction][0];
                    cStart += dir[direction][1];
                }

                direction = (direction + 1) % 4;
            }
            ++step;
        }
        return traversed;
    }
}