class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long ans = 0;
        int n = bottomLeft.length;
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                long hor = Math.max(0, Math.min(topRight[i][0], topRight[j][0]) - Math.max(bottomLeft[i][0], bottomLeft[j][0]));
                long ver = Math.max(0, Math.min(topRight[i][1], topRight[j][1]) - Math.max(bottomLeft[i][1], bottomLeft[j][1]));
                ans = Math.max(ans, Math.min(hor, ver) * Math.min(hor, ver));
            }
        }
        return ans;
    }
}