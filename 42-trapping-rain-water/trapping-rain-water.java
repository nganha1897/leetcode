class Solution {
    public int trap(int[] height) {
        int n = height.length, ans = 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        
        Deque<Integer> decStack = new ArrayDeque<>();
        decStack.add(0);
        maxLeft[0] = -1;
        for (int i=1; i<n; i++) {
            while (!decStack.isEmpty() && height[decStack.peekLast()] <= height[i]) {
                decStack.pollLast();
            }
            if (decStack.isEmpty()) {
                maxLeft[i] = -1;
            } else {
                maxLeft[i] = decStack.peekFirst();
            }
            decStack.offerLast(i);
        }
        
        while (!decStack.isEmpty() && decStack.size() > 1) {
            maxLeft[decStack.pollLast()] = decStack.peekFirst();
        }
        if (decStack.size() == 1) {
            maxLeft[decStack.pollLast()] = -1;
        }

        decStack.add(n-1);
        maxRight[n-1] = -1;
        for (int i=n-2; i>=0; i--) {
            while (!decStack.isEmpty() && height[decStack.peekLast()] <= height[i]) {
                decStack.pollLast();
            }
            if (decStack.isEmpty()) {
                maxRight[i] = -1;
            } else {
                maxRight[i] = decStack.peekFirst();
            }
            decStack.offerLast(i);
        }

        while (!decStack.isEmpty() && decStack.size() > 1) {
            maxRight[decStack.pollLast()] = decStack.peekFirst();
        }
        if (decStack.size() == 1) {
            maxRight[decStack.pollLast()] = -1;
        }
        
        for (int i=0; i<n; i++) {
            if (maxLeft[i] != -1 && maxRight[i] != -1) {
                ans += Math.min(height[maxLeft[i]], height[maxRight[i]]) - height[i];
            }
        }

        return ans;
    }
}