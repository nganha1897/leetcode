class Solution {
    public int reverse(int x) {
        int ans = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while (x != 0) {
            int d = x % 10;
            if (ans > max / 10 || (ans == max / 10 && d > 7)) {
                return 0;
            }
            if (ans < min / 10 || (ans == min / 10 && d < -8))
                return 0;
            ans = ans * 10 + d;
            x /= 10;
        }
        return ans;
    }
}