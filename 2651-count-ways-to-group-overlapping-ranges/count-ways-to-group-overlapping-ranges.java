class Solution {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a,b) -> a[0] - b[0]);
        int mod = (int)1e9 + 7;
        long ans = 2;
        for (int i=1; i<ranges.length; i++) {
            if (ranges[i][0] > ranges[i-1][1]) {
                ans = (ans * 2) % mod;
            } else {
                ranges[i][1] = Math.max(ranges[i][1], ranges[i-1][1]);
            }
        }
        return (int)ans;
    }
}