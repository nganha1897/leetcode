class Solution {
    // public int minMeetingRooms(int[][] intervals) {
    //     Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
    //     int ans = 0;
    //     for (int i=0; i<intervals.length; i++) {
    //         int s = intervals[i][0];
    //         int e = intervals[i][1];
    //         while (!pq.isEmpty() && pq.peek()[1] <= s) {
    //             pq.poll();
    //         }
    //         if (pq.size() == ans) {
    //             ans++;
    //         }
    //         pq.add(intervals[i]);
    //     }
    //     return ans;
    // }

     public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0;i<intervals.length;i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int startPointer = 0, endPointer = 0;
        int usedRooms = 0;

        while (startPointer < intervals.length) {
            if (start[startPointer] >= end[endPointer]) {
                endPointer += 1;
            } else {
                usedRooms += 1;
            }
            startPointer += 1;
        }

        return usedRooms;

    }
}