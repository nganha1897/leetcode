class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> decreasingStack = new ArrayDeque<>();
        int n = nums.length, pos = 0;
        int[] ans = new int[n-k+1];
        for (int i=0; i<n; i++) {
            while (!decreasingStack.isEmpty() && nums[decreasingStack.peekLast()] <= nums[i]) {
                decreasingStack.pollLast();
            }
            while (!decreasingStack.isEmpty() && decreasingStack.peekFirst() < i - k + 1) {
                decreasingStack.pollFirst();
            }
            decreasingStack.offerLast(i);
            if (i >= k - 1)
                ans[pos++] = nums[decreasingStack.peekFirst()];
        }
        return ans;
    }
}