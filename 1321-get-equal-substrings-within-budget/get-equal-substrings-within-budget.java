class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0, sum = 0, start = 0, len = s.length();
        int[] cost = new int[len];
        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        for (int i=0; i<s.length(); i++) {
            sum += cost[i];
            if (sum <= maxCost) {
                ans = Math.max(ans, i - start + 1);
            } else {
                while (sum > maxCost && start <= i) {
                    sum -= cost[start++];
                }
            }
        }
        return ans;
    }
}