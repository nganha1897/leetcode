class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int p = logs[0][0], maxTime = logs[0][1];
        for (int i=1; i<logs.length; i++) {
            int curTime = logs[i][1] - logs[i-1][1];
            if (curTime > maxTime) {
                maxTime = curTime;
                p = logs[i][0];
            } else if (curTime == maxTime) {
                p = Math.min(p, logs[i][0]);
            }
        }
        return p;
    }
}