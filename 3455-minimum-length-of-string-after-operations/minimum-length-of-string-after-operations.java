class Solution {
    public int minimumLength(String s) {
        int[] f = new int[26];
        int ans = 0;
        for (char c : s.toCharArray()) {
            f[c-'a']++;
        }
        for (int i=0; i<26; i++) {
            if (f[i] > 2) {
                ans += (f[i] % 2 == 0 ? 2 : 1);
            } else {
                ans += f[i];
            }
        }
        return ans;
    }
}