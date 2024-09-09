class Solution {
    public int maxProfit(int[] prices, int[] profits) {
        int n = profits.length;
        int[] max = new int[n];
        int ans = -1;

        for (int j=0; j<n-1; j++) {
            for (int k=j+1; k<n; k++) {
                if (prices[k] > prices[j] && profits[k] > max[j]) {
                    max[j] = profits[k];
                }
            }
        }

        for (int j=1; j<n; j++) {
            if (max[j] == 0) {
                continue;
            }
            int cur = max[j] + profits[j];
            for (int i=0; i<j; i++) {
                if (prices[j] > prices[i]) {
                    ans = Math.max(ans, cur + profits[i]);
                }
            }
        }
        
        
        return ans;
    }
}