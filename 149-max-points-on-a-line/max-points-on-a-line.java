class Solution {
    public int maxPoints(int[][] points) {
        int max = 1, n = points.length;
        for (int i=0; i<n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j=i+1; j<n; j++) {
                int cur = 2;
                int x2 = points[j][0], y2 = points[j][1];
                for (int k=j+1; k<n; k++) {
                    int x3 = points[k][0], y3 = points[k][1];
                    if ((x1 - x3) * (y1 - y2) == (x1 - x2) * (y1 - y3)) {
                        cur++;
                    }
                }
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}