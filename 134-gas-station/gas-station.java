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
            i = (i + 1) % n; 
            if (sum < 0) {         
                ans = i;
                sum = 0;
            } else {
                if (i == ans) {
                    return ans;
                }
            }
        }
        return -1;
    }
}