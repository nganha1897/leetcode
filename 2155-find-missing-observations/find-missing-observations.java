class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = mean * (m + n);
        for (int r : rolls) {
            sum -= r;
        }
        if (sum < n || sum > n * 6) {
            return new int[0];
        }
        int[] ans = new int[n];
        for (int i=0; i<n; i++) {
            int r = 1;
            while (r < 6 && !((sum - r) >= (n - i - 1) && (sum - r) <= 6 * (n - i -1))) {
                r++;
            }
            ans[i] = r;
            sum -= r;
        }
        return ans;
    }
}