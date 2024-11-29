class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1;
        
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int r=0; r<m; r++) {
            Arrays.fill(dist[r], Integer.MAX_VALUE);
        }
        int[] dir = new int[] {-1, 0, 1, 0, -1}; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[] {0, 0, 0});
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == m-1 && cur[1] == n-1)
                return cur[2];
            int r = cur[0], c = cur[1], t = cur[2];
            for (int d=0; d<4; d++) {
                int nextR = r + dir[d];
                int nextC = c + dir[d+1];
                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n) {
                    if (dist[nextR][nextC] > t + 1 && grid[nextR][nextC] <= t + 1) {
                        dist[nextR][nextC] = t + 1;
                        pq.add(new int[] {nextR, nextC, t+1});
                    } else if (grid[nextR][nextC] > t + 1) {
                        int nextT = grid[nextR][nextC] + ((grid[nextR][nextC] - t) % 2 == 1 ? 0 : 1);
                        if (dist[nextR][nextC] > nextT) {
                            dist[nextR][nextC] = nextT;
                            pq.add(new int[] {nextR, nextC, nextT});
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}