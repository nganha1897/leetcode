class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<int[]> inUse = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        int room = 0;
        int[] ans = new int[n];
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        for (int i=0; i<meetings.length; i++) {
            while (!inUse.isEmpty() && inUse.peek()[0] <= meetings[i][0]) {
                int[] curRoom = inUse.poll();
                freeRooms.add(curRoom[1]);      
            }
            if (!freeRooms.isEmpty()) {    
                int curRoom = freeRooms.poll();   
                inUse.add(new int[] {meetings[i][1], curRoom});
                ans[curRoom]++;
            } else if (room < n) {
                inUse.add(new int[] {meetings[i][1], room});
                ans[room]++;
                room++;
            } else {
                int[] curRoom = inUse.poll();
                inUse.add(new int[] {curRoom[0] + meetings[i][1] - meetings[i][0], curRoom[1]});
                ans[curRoom[1]]++;
            }
        }
        int max = 0, maxRoom = 0;
        for (int i=0; i<ans.length; i++) {
            if (ans[i] > max) {
                max = ans[i];
                maxRoom = i;
            }
        }

        return maxRoom;
    }
}