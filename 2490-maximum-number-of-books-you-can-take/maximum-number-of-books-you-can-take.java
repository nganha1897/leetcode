class Solution {
    public long maximumBooks(int[] books) {
        int n = books.length;
        long ans = books[0];
        long dp[] = new long[n];
        dp[0] = books[0];
        Deque<Integer> idx = new ArrayDeque<>();
        idx.offer(0);

        for (int i=1; i<n; i++) {
            while (!idx.isEmpty() && books[idx.peekLast()] >= books[i] - (i - idx.peekLast())) {
                idx.pollLast();
            }
            if (idx.isEmpty()) {
                int start = Math.max(1, books[i] - i);
                dp[i] = (long)(books[i] + start) * (books[i] - start + 1) / 2;
                System.out.println("empty " + i + " " + dp[i]);
            } else {
                int j = idx.peekLast();
                dp[i] = dp[j] + (long)(books[i] + books[i] - (i - j - 1)) * (i - j) / 2;
                System.out.println(i + " " + dp[i]);
            }
            ans = Math.max(ans, dp[i]);
            idx.offerLast(i);
        }

        //System.out.println(Arrays.toString(dp));
        return ans;
    }
}