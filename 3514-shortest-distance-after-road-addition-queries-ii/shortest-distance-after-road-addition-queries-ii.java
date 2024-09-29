class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = queries.length, len = n - 1;
        int[] ans = new int[m];

        for (int i=0; i<n-1; i++) {
            map.put(i, i+1);
        }

        for (int i=0; i<m; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (!map.containsKey(u) || map.get(u) >= v) {
                ans[i] = map.size();
                continue;
            }
            int j = map.get(u);
            while (j < v) {
                j = map.remove(j);
            }
            map.put(u, v);
            ans[i] = map.size();
        }
        return ans;
    }
}