class Solution {
    public long dividePlayers(int[] skill) {
        int sum = 0, n = skill.length;
        int[] f = new int[1001];
        for (int i=0; i<n; i++) {
            sum += skill[i];
            f[skill[i]]++;
        }
        int teams = n / 2;
        if ((sum % teams) != 0) {
            return -1;
        }
        int score = sum / teams;
        long ans = 0;
        for (int i=0; i<n; i++) {
            if (f[skill[i]] != 0) {
                f[skill[i]]--;
                if (f[score - skill[i]]-- == 0) {
                    return -1;
                }
                ans += (long)skill[i] * (score-skill[i]);
            }
        }
        return ans;
    }
}