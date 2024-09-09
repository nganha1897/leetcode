class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int max = skills[0];
        int n = skills.length;
        int[] dp = new int[n];
        Deque<Integer> dec = new ArrayDeque<>();
        dec.add(n-1);
        for (int i=n-2; i>=0; i--) {
            while (!dec.isEmpty() && skills[dec.peekLast()] < skills[i]) {
                dec.pollLast();
            }
            if (!dec.isEmpty()) {
                dp[i] = dec.peekLast() - i - 1;
            } else {
                dp[i] = n - i - 1;
            }
            dec.offerLast(i);
        }
        //System.out.println(Arrays.toString(dp));
        if (dp[0] >= k) {
            return 0;
        }
        for (int i=1; i<skills.length; i++) {
            int wins = 1;
            if (skills[i] > max) {
                if (k == 1 || dp[i] + 1 >= k || dp[i] == n - i - 1) {
                    return i;
                }
                max = skills[i];
            }
        }
        return 0;
    }
}