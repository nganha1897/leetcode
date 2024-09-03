class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int ans = 0;
        for (int i=0; i<n; i++) {
            gas[i] = gas[i] - cost[i];
        }
        int sum = 0;
        for (int i=0, count=0; i<n && count<2*n; count++) {
            sum += gas[i];
            if (sum < 0) {
                i = (i + 1) % n; 
                if (i == 0) {
                    return -1;
                }
                ans = i;
                sum = 0;
            } else {
                i = (i + 1) % n; 
                if (i == ans) {
                    return ans;
                }
            }
        }
        return -1;
    }
}