class MyCalendar {
    
    private TreeMap<Integer, Integer> calendar;
    
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prevStart = calendar.floorKey(end-1);
        if (prevStart != null) {
            if (prevStart >= start)
                return false;
            int prevEnd = calendar.get(prevStart);
            if (prevEnd > start)
                return false;
        } 
        calendar.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */