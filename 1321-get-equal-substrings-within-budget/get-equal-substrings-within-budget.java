class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0, sum = 0, start = 0, len = s.length();
        int[] cost = new int[len];
        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            sum += cost[i];
            while (sum > maxCost) {
                sum -= cost[start++];
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}