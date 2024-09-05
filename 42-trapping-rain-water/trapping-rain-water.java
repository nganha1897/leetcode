class Solution {
    // public int trap(int[] height) {
    //     int n = height.length, ans = 0, maxLeft = 0, maxRight = 0;
    //     for (int i = 1; i < n; i++) {
    //         if (maxLeft[i - 1] == -1) {
    //             if (height[i - 1] <= height[i])
    //                 maxLeft[i] = -1;
    //             else
    //                 maxLeft[i] = i - 1;
    //         } else {
    //             if (height[maxLeft[i - 1]] <= height[i]) {
    //                 maxLeft[i] = -1;
    //             } else {
    //                 maxLeft[i] = maxLeft[i - 1];
    //             }
    //         }
    //     }

    //     maxRight[n - 1] = -1;
    //     for (int i = n-2; i>=0; i--) {
    //         if (maxRight[i + 1] == -1) {
    //             if (height[i + 1] <= height[i])
    //                 maxRight[i] = -1;
    //             else
    //                 maxRight[i] = i + 1;
    //         } else {
    //             if (height[maxRight[i + 1]] <= height[i]) {
    //                 maxRight[i] = -1;
    //             } else {
    //                 maxRight[i] = maxRight[i + 1];
    //             }
    //         }
    //     }

    //     for (int i = 0; i < n; i++) {
    //         if (maxLeft[i] != -1 && maxRight[i] != -1) {
    //             ans += Math.min(height[maxLeft[i]], height[maxRight[i]]) - height[i];
    //         }
    //     }

    //     return ans;
    // }
    // public int trap(int[] height) {
    //     int ans = 0, current = 0;
    //     Deque<Integer> st = new LinkedList<Integer>();
    //     while (current < height.length) {
    //         while (!st.isEmpty() && height[current] > height[st.peek()]) {
    //             int top = st.peek();
    //             st.pop();
    //             if (st.isEmpty()) break;
    //             int distance = current - st.peek() - 1;
    //             int bounded_height =
    //                 Math.min(height[current], height[st.peek()]) - height[top];
    //             ans += distance * bounded_height;
    //         }
    //         st.push(current++);
    //     }

    //     return ans;
    // }

    public int trap(int[] height) {
        int n = height.length, s=0, e=n-1, maxLeft = 0, maxRight = 0, ans = 0;
        while (s < e) {
            if (height[s] < height[e]) {
                if (height[s] >= maxLeft) {
                    maxLeft = height[s];
                } else {
                    ans += maxLeft - height[s];
                }
                s++;
            } else {
                if (height[e] >= maxRight) {
                    maxRight = height[e];
                } else {
                    ans += maxRight - height[e];
                }
                e--;
            }
        }
        return ans;
    }
}