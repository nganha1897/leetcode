class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int ans = 0, len = intervals.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i=0; i<len; i++) {
            int st = intervals[i][0], e = intervals[i][1];
            Integer lastEnd = map.floorKey(st - 1);
            if (lastEnd != null) {
                map.put(e, map.getOrDefault(e, 0) + 1);
                map.put(lastEnd, map.get(lastEnd) - 1);
                if (map.get(lastEnd) == 0) {
                    map.remove(lastEnd);
                }
            } else {
                map.put(e, map.getOrDefault(e, 0) + 1);
                ans++;
            }
        }
        return ans;
    }
}