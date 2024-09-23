class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], -1);
        }
        for (int[] e : edges) {
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }

        int ans = 0;
        boolean[] visited = new boolean[n];
        Queue<int[]> bfs = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        bfs.offer(new int[] {0, 0});

        while (!bfs.isEmpty()) {
            int[] cur = bfs.poll();
            int start = cur[0];
            int move = cur[1];

            if (visited[start]) {
                continue;
            }
            visited[start] = true;
            ans++;
            for (int i=0; i<n; i++) {
                if (graph[start][i] > -1) {
                    int curDist = move + graph[start][i] + 1;
                    if (!visited[i] && curDist <= maxMoves) {
                        bfs.add(new int[] {i, curDist});
                    }
                    graph[i][start] -= Math.min(graph[start][i], maxMoves - move);
                    ans += Math.min(graph[start][i], maxMoves - move);
                }              
            }
        }
        return ans;
    }
}