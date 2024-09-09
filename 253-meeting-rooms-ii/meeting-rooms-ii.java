class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int ans = 0;
        for (int i=0; i<intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            while (!pq.isEmpty() && pq.peek()[1] <= s) {
                pq.poll();
            }
            if (pq.size() == ans) {
                ans++;
            }
            pq.add(intervals[i]);
        }
        return ans;
    }
}