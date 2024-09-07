class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] loc = new int[n*n+1];
        
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

        int[] dist = new int[n*n+1];
        Arrays.fill(dist, n*n+1);
        Deque<Integer> q = new LinkedList<>();
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == n*n) {
                return dist[cur];
            }
            for (int next=cur+1; next<=Math.min(cur+6, n*n); next++) {                
                int dest = loc[next] == -1 ? next : loc[next];
                if (dist[dest] == n*n+1) {
                    dist[dest] = dist[cur] + 1;
                    q.add(dest);
                }
            }
        }
        return dist[n*n] == n*n+1 ? -1 : dist[n*n];
    }
}