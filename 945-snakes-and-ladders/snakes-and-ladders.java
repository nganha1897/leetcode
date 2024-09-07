class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n*n+1];
        int label = 1;
        Integer[] columns = new Integer[n];
        for (int i=0; i<n; i++) {
            columns[i] = i;
        }

        for (int row = n-1; row >=0; row--) {
            for (int column : columns) {
                cells[label++] = new Pair<>(row, column);
            }
            Collections.reverse(Arrays.asList(columns));
        }

        int[] dist = new int[n*n+1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<Integer>();
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next=cur+1; next<=Math.min(cur+6, n*n); next++) {
                int r = cells[next].getKey();
                int c = cells[next].getValue();
                int dest = board[r][c] == -1 ? next : board[r][c];
                if (dist[dest] == -1) {
                    dist[dest] = dist[cur] + 1;
                    q.add(dest);
                }
            }
        }
        return dist[n*n];
    }
}