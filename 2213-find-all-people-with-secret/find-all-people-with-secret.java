class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        List<Integer> ans = new ArrayList<>();
        boolean[] reached = new boolean[n];
        List<List<int[]>> adj = new ArrayList<>();
        
        for (int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for (int[] m : meetings) {
            adj.get(m[0]).add(new int[] {m[1], m[2]});
            adj.get(m[1]).add(new int[] {m[0], m[2]});
        }

        //reached[0] = true;
        pq.add(new int[] {0, firstPerson});
        pq.add(new int[] {0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (reached[cur[1]])
                continue;
            reached[cur[1]] = true;
            for (int[] nei : adj.get(cur[1])) {
                if (nei[1] >= cur[0]) {
                    pq.add(new int[] {nei[1], nei[0]});
                }
            }
        }

        for (int i=0; i<reached.length; i++) {
            if (reached[i])
                ans.add(i);
        }
        return ans;
    }
}