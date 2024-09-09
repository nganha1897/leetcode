class Solution {
    public int maxProfit(int[] prices, int[] profits) {
        int n = profits.length;
        int[] max = new int[n];
        int[] min = new int[n];
        for (int j=0; j<n-1; j++) {
            for (int k=j+1; k<n; k++) {
                if (prices[k] > prices[j] && profits[k] > max[j]) {
                    max[j] = profits[k];
                }
            }
        }

        for (int j=1; j<n; j++) {
            for (int i=0; i<j; i++) {
                if (prices[j] > prices[i] && profits[i] > min[j]) {
                    min[j] = profits[i];
                }
            }
        }
        int ans = -1;
        for (int i=1; i<n-1; i++) {
            if (max[i] != 0 && min[i] != 0) {
                ans = Math.max(ans, max[i] + min[i] + profits[i]);
            }
        }
        return ans;
    }
}