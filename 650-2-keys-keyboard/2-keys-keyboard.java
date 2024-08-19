// class Solution {
//     public int minSteps(int n) {
//         int[][] dp = new int[n+1][n+1];
//         for (int i=2; i<dp.length; i++) {
//             for (int j=1; j<i; j++) {
//                 dp[i][j] = Math.min(dp)
//             }
//         }
//     }
// }

class Solution {

    public int minSteps(int n) {
        int ans = 0;
        int d = 2;
        while (n > 1) {
            // If d is prime factor, keep dividing
            // n by d until is no longer divisible
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}