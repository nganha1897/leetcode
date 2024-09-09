class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length, count = 0;
        int cur = 0;
        for (int i=1; i<n; i++) {
            if (skills[cur] > skills[i]) {
                count++;
            } else {
                count = 1;
                cur = i;
            }
            if (count == k) {
                    return cur;
                }
        }
        return cur;
    }
}