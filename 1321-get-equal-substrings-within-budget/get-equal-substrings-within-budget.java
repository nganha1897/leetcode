class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0, sum = 0, start = 0;
        for (int i=0; i<s.length(); i++) {
            sum += Math.abs(s.charAt(i) - t.charAt(i));
            if (sum <= maxCost) {
                ans = Math.max(ans, i - start + 1);
            } else {
                while (sum > maxCost && start <= i) {
                    sum -= Math.abs(s.charAt(start) - t.charAt(start++));
                }
            }
        }
        return ans;
    }
}