class Solution {
    public int findMinDifference(List<String> timePoints) {
        int min = 24 * 60, n = timePoints.size(), max = min;
        List<Integer> time = new ArrayList<>();
        for (int i=0; i<timePoints.size(); i++) {
            time.add(convert(timePoints.get(i)));
        }
        Collections.sort(time);

        for (int i=1; i<time.size(); i++) {
            min = Math.min(min, time.get(i) - time.get(i-1));
        }
        min = Math.min(min, max - time.get(n-1) + time.get(0));
        return min;
    }
    public int convert(String s) {
        String[] time = s.split(":");
        return Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
    }
}