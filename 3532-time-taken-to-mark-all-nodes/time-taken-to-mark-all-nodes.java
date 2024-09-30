class Solution {
    public int[] timeTaken(int[][] edges) {
        int n = edges.length + 1;
        int[] ans = new int[n];
        int[][] dp = new int[n][2];
        List<Integer>[] adj = new List[n];

        for (int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] x : edges) {
            adj[x[0]].add(x[1]);
            adj[x[1]].add(x[0]);
        }

        dfs(0, -1, ans, adj, dp);

        findMax(0, -1, 0, ans, adj, dp);

        return ans;
    }

    private void dfs(int root, int prev, int[] ans, List<Integer>[] adj, int[][] dp) {
        int cur;
        for (int j : adj[root]) {
            if (j != prev) {
                dfs(j, root, ans, adj, dp);
                cur = dp[j][0] + (j % 2 == 1 ? 1 : 2);
                if (cur > dp[root][0]) {
                    dp[root][1] = dp[root][0];
                    dp[root][0] = cur;
                } else if (cur > dp[root][1]) {
                    dp[root][1] = cur;
                }
            }
        }
    }

    private void findMax(int root, int prev, int incoming, int[] ans, List<Integer>[] adj, int[][] dp) {
        ans[root] = Math.max(dp[root][0], incoming);
        int pa = (root % 2 == 1 ? 1 : 2);
        int cur, x;

        for (int j : adj[root]) {
            if (j != prev) {
                cur = dp[j][0] + (j % 2 == 1 ? 1 : 2);

                if (cur == dp[root][0]) {
                    x = dp[root][1];
                } else {
                    x = dp[root][0];
                }
                findMax(j, root, Math.max(pa + incoming, pa + x), ans, adj, dp);
            }
        }
    }
}