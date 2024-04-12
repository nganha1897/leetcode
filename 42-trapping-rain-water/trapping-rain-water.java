class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 2)
            return 0;
        int[] leftTallest = new int[len];
        int[] rightTallest = new int[len];
        int res=0;
        leftTallest[0] = height[0];
        rightTallest[len-1] = height[len-1];
        for (int i=1; i<len-1; i++) {
            leftTallest[i] = Math.max(leftTallest[i-1], height[i]);
            rightTallest[len-1-i] = Math.max(rightTallest[len-i], height[len-1-i]);
        }
        leftTallest[len-1] = Math.max(leftTallest[len-2], height[len-1]);
        rightTallest[0] = Math.max(rightTallest[1], height[0]);
        for (int j=1; j<len-1; j++) {
            if (leftTallest[j] > height[j] && rightTallest[j] > height[j]) {
                res += Math.min(leftTallest[j], rightTallest[j]) - height[j];
            }
        }
        return res;
    }
}