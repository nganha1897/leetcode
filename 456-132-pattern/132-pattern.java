class Solution {
    // public boolean find132pattern(int[] nums) {
    //     int n = nums.length;
    //     int[] min = new int[n];
    //     min[0] = nums[0];
    //     for (int i = 1; i < n; i++) {
    //         min[i] = Math.min(min[i - 1], nums[i]);
    //     }
    //     Deque<Integer> d = new ArrayDeque<>();
    //     for (int i = n - 1; i >= 0; i--) {
    //         if (nums[i] > min[i]) {
    //             while (!d.isEmpty() && nums[d.peekLast()] <= min[i]) {
    //                 d.pollLast();
    //             }
    //             if (!d.isEmpty() && nums[d.peekLast()] < nums[i] && nums[i] > min[i] && nums[d.peekLast()] > min[i]) {
    //                 return true;
    //             }
    //             d.offerLast(i);
    //         }
    //     }
    //     return false;
    // }

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] decreasingStack = new int[n];
        int[] min = new int[n];
        min[0] = nums[0];

        for (int i=1; i<n; i++)
            min[i] = Math.min(nums[i-1], min[i-1]);    
        
        int stackIdx = -1;
        for (int i=0; i<n; i++) {
            while (stackIdx >= 0 && nums[decreasingStack[stackIdx]] <= nums[i])
                stackIdx--;
            if (stackIdx >= 0 && min[decreasingStack[stackIdx]] < nums[i])
                return true;
            decreasingStack[++stackIdx] = i;
        }
        
        return false;
    }
}