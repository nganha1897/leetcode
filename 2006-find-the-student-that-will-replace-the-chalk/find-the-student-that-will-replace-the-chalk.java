class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] preSum = new long[n];

        preSum[0] = chalk[0];
        for (int i=1; i<n; i++) {
            preSum[i] = preSum[i-1] + chalk[i];
        }

        long lastSum = k %  preSum[n-1];

        for (int i=0; i<n; i++) {
            if (preSum[i] > lastSum) {
                return i;
            }
        }

        return -1;
    }
}