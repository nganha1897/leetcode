class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        for (int[] i : intervals) {
            if (ans.size() == 0) {
                ans.add(i);
            } else {
                int size = ans.size();
                if (ans.get(size-1)[1] >= i[0]) {
                    ans.get(size-1)[1] = Math.max(ans.get(size-1)[1], i[1]);
                } else {
                    ans.add(i);
                }
            }
        }
        int[][] res = new int[ans.size()][];
        for (int i=0; i<res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}