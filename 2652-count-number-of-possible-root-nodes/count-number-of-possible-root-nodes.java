class Solution {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int ans = 0;
        Map<Integer, Set<Integer>> mapGuesses = new HashMap<>(); 
        for (int[] g : guesses) {
            mapGuesses.computeIfAbsent(g[0], v -> new HashSet<>()).add(g[1]);
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] e : edges) {
            adj.computeIfAbsent(e[0], v -> new ArrayList<>()).add(e[1]);
            adj.computeIfAbsent(e[1], v -> new ArrayList<>()).add(e[0]);
        }
        int n = adj.size();
        int root = 0;
        int correct = 0;
        Deque<Integer> vertices = new ArrayDeque<>();
        vertices.add(root);
        boolean[] visited = new boolean[n];
        while (!vertices.isEmpty()) {
            int cur = vertices.pollFirst();
            visited[cur] = true;
            Set<Integer> guessList = mapGuesses.getOrDefault(cur, new HashSet<>());
            for (int nei : adj.get(cur)) {
                if (!visited[nei]) {  
                    if (guessList.contains(nei)) {
                        correct++;
                    }
                    vertices.add(nei);
                }
            }
        }
        if (correct >= k) {
            ans++;
        }
        Deque<int[]> curVertices = new ArrayDeque<>();
        visited = new boolean[n];
        curVertices.add(new int[] {root, correct});
        while (!curVertices.isEmpty()) {
            int[] cur = curVertices.pollFirst();
            visited[cur[0]] = true;
            Set<Integer> guessList2 = mapGuesses.getOrDefault(cur[0], new HashSet<>());

            for (int nei : adj.get(cur[0])) {
                if (visited[nei]) {
                    continue;
                }
                Set<Integer> guessList = mapGuesses.getOrDefault(nei, new HashSet<>());
                int curCorrect = cur[1];
                if (guessList.contains(cur[0])) {
                    curCorrect++;
                }
               
                if (guessList2.contains(nei)) {
                    curCorrect--;
                }
                if (curCorrect >= k) {
                    ans++;
                }
                //System.out.println(cur[0] + " " + cur[1] + " " + nei + " " + curCorrect);
                
                curVertices.add(new int[] {nei, curCorrect});
            }
        }
        return ans;
    }
}