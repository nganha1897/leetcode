class Solution {
    // public int makeConnected(int n, int[][] connections) {
    //     int edges = connections.length;
    //     if (edges < n-1) {
    //         return -1;
    //     }
    //     boolean[] visited = new boolean[n];
    //     int groups = 0;
    //     Set<Integer>[] adj = new Set[n];

    //     for (int i=0; i<n; i++) {
    //         adj[i] = new HashSet<>();
    //     }
    //     for (int[] c : connections) {
    //         adj[c[0]].add(c[1]);
    //         adj[c[1]].add(c[0]);
    //     }
        
    //     for (int i=0; i<n; i++) {
    //         if (!visited[i]) {
    //             groups++;
    //             Deque<Integer> neighbors = new ArrayDeque<>();
    //             neighbors.add(i);
    //             while (neighbors.size() > 0) {
    //                 int cur = neighbors.pollFirst();
    //                 visited[cur] = true;
    //                 for (int nei : adj[cur]) {
    //                     adj[nei].remove(cur);
    //                     if (!visited[nei]) {
    //                         neighbors.add(nei);
    //                     }
    //                 }
    //             }
    //         }
    //     }

    //     return groups - 1;
        
    // }

    public void bfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;

        while (!q.isEmpty()) {
            node = q.poll();
            if (!adj.containsKey(node)) {
                continue;
            }
            for (int neighbor : adj.get(node)) {
                if (!visit[neighbor]) {
                    visit[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<Integer>()).add(connection[1]);
            adj.computeIfAbsent(connection[1], k -> new ArrayList<Integer>()).add(connection[0]);
        }

        int numberOfConnectedComponents = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfConnectedComponents++;
                bfs(i, adj, visit);
            }
        }

        return numberOfConnectedComponents - 1;
    }
}