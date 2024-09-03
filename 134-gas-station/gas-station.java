class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int sum = 0;
        int curSum = 0;
        for (int i=0; i<n; i++) {
            sum += gas[i] - cost[i];
            curSum += gas[i] - cost[i];
            if (curSum < 0) {         
                start = i+1;
                curSum = 0;
            }
        }
        return sum >= 0 ? start : -1;
    }
}