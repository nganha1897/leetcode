class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetStart = times[targetFriend][0];
        Arrays.sort(times, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> availSeats = new PriorityQueue<>();
        for (int i=0; i<times.length; i++)
            availSeats.offer(i);
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        for (int i=0; i<times.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= times[i][0]) {
                availSeats.offer(pq.poll()[1]);
            }
            
            if (times[i][0] == targetStart)
                break;
            
            pq.offer(new int[] {times[i][1], availSeats.poll()});
        }
        
        return availSeats.peek();
    }
}