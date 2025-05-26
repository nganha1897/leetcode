class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[][] colorCount = new int[n][26];
        List<Integer>[] adjList = new List[n];
        int[] inDegree = new int[n];

        for (int i=0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adjList[e[0]].add(e[1]);
            inDegree[e[1]]++;
        }
        
        int ans = -1;

        Deque<Integer> d = new ArrayDeque<>();
        for (int i=0; i<n; i++) {
            if (inDegree[i] == 0) {
                d.offerLast(i);
            }
        }

        while (!d.isEmpty()) {
            int cur = d.pollFirst();
            int color = colors.charAt(cur) - 'a';
            colorCount[cur][color]++;
            ans = Math.max(ans, colorCount[cur][color]);
            for (int nei : adjList[cur]) {
                for (int i=0; i<26; i++) {
                    colorCount[nei][i] = Math.max(colorCount[nei][i], colorCount[cur][i]);
                }
                if (--inDegree[nei] == 0) {
                    d.offerLast(nei);
                }
                
            }
        }
        
        for (int i=0; i<n; i++) {
            if (inDegree[i] > 0) {
                return -1;
            }
        }

        return ans;
    }
}