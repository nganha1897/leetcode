class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<int[]> d = new ArrayDeque<>();
        for (int i=0; i<logs.size(); i++) {
            String[] cur = logs.get(i).split(":");
            int id = Integer.valueOf(cur[0]);
            int time = Integer.valueOf(cur[2]);
            if (cur[1].equals("start")) {
                if (!d.isEmpty()) {
                    int[] prev = d.peekLast();
                    ans[prev[0]] += time - prev[1];
                }
                d.offerLast(new int[] {id, time});
            } else {
                int[] start = d.pollLast();
                ans[start[0]] += time - start[1] + 1;
                if (!d.isEmpty()) {
                    int[] prev = d.pollLast();
                    d.offerLast(new int[] {prev[0], time+1});
                }
            }
        }
        return ans;
    }
}