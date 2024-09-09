class Solution {
    public int countWays(int[][] ranges) {
        List<int[]> groups  = new ArrayList<>();
        Arrays.sort(ranges, (a,b) -> a[0] - b[0]);

        for (int i=0; i<ranges.length; i++) {
            if (groups.size() == 0) {
                groups.add(ranges[i]);
            } else {
                int last = groups.size() - 1;
                if (groups.get(last)[1] >= ranges[i][0]) {
                    groups.get(last)[1] = Math.max(groups.get(last)[1], ranges[i][1]);
                } else {
                    groups.add(ranges[i]);
                }
            }
        }

        return (int)(power(2, groups.size(), (int)(1e9+7)));
    }
    private long power(int x, int p, int mod) {
        if (p == 0) {
            return 1;
        }

        long res = power(x, p >> 1, mod);
        res = (res * res) % mod;
        if (p % 2 == 1) {
            res = (res * x) % mod;
        }
        return res;
    }
}