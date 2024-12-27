class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int bestPos = 0;
        for (int i=1; i<values.length; i++) {
            ans = Math.max(ans, values[i] + values[bestPos] - i + bestPos);
            if (values[i] >= values[bestPos] || i - bestPos >= values[bestPos] - values[i]) {
                bestPos = i;
            }
        }
        return ans;
    }
}