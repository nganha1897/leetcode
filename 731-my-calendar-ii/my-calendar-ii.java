class MyCalendarTwo {

    TreeMap<Integer, Integer> calendar;
    public MyCalendarTwo() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        
        int res = 0;
        for (int v : calendar.values()) {
            res += v;
            if (res == 3) {
                calendar.put(start, calendar.get(start) - 1);
                calendar.put(end, calendar.get(end) + 1);
                
                //if (calendar.get(start) == 0)
                  //  calendar.remove(start);
                //if (calendar.get(end) == 0)
                    //calendar.remove(end);
                
                return false;
            }
        }
        return true;
    }
}

/*
public class MyCalendarTwo {
    List<int[]> calendar;
    List<int[]> overlaps;

    MyCalendarTwo() {
        overlaps = new ArrayList();
        calendar = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] iv: overlaps) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        for (int[] iv: calendar) {
            if (iv[0] < end && start < iv[1])
                overlaps.add(new int[]{Math.max(start, iv[0]), Math.min(end, iv[1])});
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}*/

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */