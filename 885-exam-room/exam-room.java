class ExamRoom {
    private PriorityQueue<int[]> seats;
    private TreeSet<Integer> room;
    private int n;
    public ExamRoom(int n) {
        seats = new PriorityQueue<>((a,b) -> a[1]/2 == b[1]/2 ? (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]) : b[1]/2 - a[1]/2);
        room = new TreeSet<>();
        this.n = n;
    }
    
    public int seat() {
        if (room.size() == 0) {
            room.add(0);
            seats.add(new int[] {0, (n-1) * 2});
        } else {
            while (!seats.isEmpty()) {
                int[] cur = seats.poll();
                if (room.contains(cur[0]) || cur[0] < 0) {
                    int newPos = cur[0] + cur[1] / 2;
                    //System.out.println(456 + " " + newPos);
                    if (newPos >= n || newPos < 0 || room.contains(newPos)) {
                        //System.out.println(123 + " " + newPos);
                        continue;
                    }
                    room.add(newPos);
                    seats.add(new int[] {newPos, cur[1] - cur[1]/2});
                    seats.add(new int[] {cur[0], cur[1]/2});
                    // System.out.println(newPos + " " + Arrays.toString(cur));
                    // System.out.println(newPos + " " + (cur[1] - cur[1]/2));
                    // System.out.println(cur[0] + " " + cur[1]/2);
                    return cur[0] + cur[1]/2;
                }
            }
        }
        return 0;
    }
    
    public void leave(int p) {
        room.remove(p);
        Integer lower = room.floor(p);
        Integer higher = room.ceiling(p);
        if (lower == null && higher == null) 
            return;
        if (lower == null) lower = -higher;
        if (higher == null) higher = lower + (n-1-lower) * 2;
        //System.out.println(lower + " " + higher);
        seats.add(new int[] {lower, higher-lower});
    }
}



/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */