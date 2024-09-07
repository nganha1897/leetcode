class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length, dest = n*n;
        int[] loc = new int[dest+1];
        
        int val = 1;
        boolean forDir = true;
        for (int r=n-1; r>=0; r--) {
            if (forDir) {
                for (int c=0; c<n; c++) {
                    loc[val++] = board[r][c];
                }
            } else {
                for (int c=n-1; c>=0; c--) {
                    loc[val++] = board[r][c];
                }
            }
            forDir = !forDir;
        }

        boolean[] visited = new boolean[dest+1];
        int start = (loc[1] == -1 ? 1 : loc[1]);
        Deque<int[]> d = new ArrayDeque<>();
        d.offerLast(new int[] {start, 0});
        visited[start] = true;

        while (!d.isEmpty()) {
            int[] cur = d.pollFirst();
            if (cur[0] == dest)
                return cur[1];
            for (int i=1; i<=6; i++) {
                if (cur[0] + i > dest)
                    break;
                int next = loc[cur[0] + i] == -1 ? cur[0] + i : loc[cur[0] + i];
                if (!visited[next]) {
                    d.offerLast(new int[] {next, cur[1] + 1});
                    visited[next] = true;
                }
            }
        }

        return -1;
    }
}