class Solution {
    public int trap(int[] height) {
        int n = height.length, ans = 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = -1;
        for (int i = 1; i < n; i++) {
            if (maxLeft[i - 1] == -1) {
                if (height[i - 1] <= height[i])
                    maxLeft[i] = -1;
                else
                    maxLeft[i] = i - 1;
            } else {
                if (height[maxLeft[i - 1]] <= height[i]) {
                    maxLeft[i] = -1;
                } else {
                    maxLeft[i] = maxLeft[i - 1];
                }
            }
        }

        maxRight[n - 1] = -1;
        for (int i = n-2; i>=0; i--) {
            if (maxRight[i + 1] == -1) {
                if (height[i + 1] <= height[i])
                    maxRight[i] = -1;
                else
                    maxRight[i] = i + 1;
            } else {
                if (height[maxRight[i + 1]] <= height[i]) {
                    maxRight[i] = -1;
                } else {
                    maxRight[i] = maxRight[i + 1];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (maxLeft[i] != -1 && maxRight[i] != -1) {
                ans += Math.min(height[maxLeft[i]], height[maxRight[i]]) - height[i];
            }
        }

        // System.out.println(Arrays.toString(maxLeft));
        // System.out.println(Arrays.toString(maxRight));
        return ans;
    }
}