class Solution {
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if (edges < n-1) {
            return -1;
        }
        boolean[] visited = new boolean[n];
        int groups = 0;
        Set<Integer>[] adj = new Set[n];

        for (int i=0; i<n; i++) {
            adj[i] = new HashSet<>();
        }
        for (int[] c : connections) {
            adj[c[0]].add(c[1]);
            adj[c[1]].add(c[0]);
        }
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                groups++;
                Deque<Integer> neighbors = new ArrayDeque<>();
                neighbors.offerLast(i);
                visited[i] = true;
                while (neighbors.size() > 0) {
                    int cur = neighbors.pollFirst();
                    for (int nei : adj[cur]) {
                        if (!visited[nei]) {
                            visited[nei] = true;
                            neighbors.offerLast(nei);
                        }
                    }
                }
            }
        }

        return groups - 1;
        
    }
}