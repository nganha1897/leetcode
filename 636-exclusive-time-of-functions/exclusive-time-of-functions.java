class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<int[]> d = new ArrayDeque<>();
        for (int i=0; i<logs.size(); i++) {
            String[] cur = logs.get(i).split(":");
            int id = Integer.valueOf(cur[0]);
            int time = Integer.valueOf(cur[2]);
            if (cur[1].equals("start")) {
                d.offerLast(new int[] {id, time});
            } else {
                int[] start = d.pollLast();
                ans[start[0]] += time - start[1] + 1;
                if (!d.isEmpty()) {
                    ans[d.peekLast()[0]] -= time - start[1] + 1;
                }
            }
        }
        return ans;
    }
}