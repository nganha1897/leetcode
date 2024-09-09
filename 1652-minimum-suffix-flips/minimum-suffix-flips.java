class Solution {
    public int minFlips(String target) {
        int ans = 0;
        for (int i=0; i<target.length(); i++) {
            char c = target.charAt(i);
            if (c == '1' && (ans % 2) == 0) {
                ans++;
            } else if (c == '0' && (ans % 2) == 1) {
                ans++;
            }
        }
        return ans;
    }
}