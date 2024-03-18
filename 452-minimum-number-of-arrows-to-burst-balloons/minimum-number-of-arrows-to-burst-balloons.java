class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length, ans = 1;
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int prev = points[0][1];
        
        for (int i=1; i<n; i++) {
            if (prev < points[i][0]) {
                ans++;
                prev = points[i][1];
            }
        }
        return ans;
    }
}