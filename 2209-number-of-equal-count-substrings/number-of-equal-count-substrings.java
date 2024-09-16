class Solution {
    public int equalCountSubstrings(String s, int count) {
        if (s == null || s.length() == 0 || count > s.length()) {
            return 0;
        }
        int ans = 0;
        int n = s.length();
        Set<Character> maxUnique = new HashSet<>();
        for (char c: s.toCharArray()) {
            maxUnique.add(c);
        }
        for (int i=1; i<=maxUnique.size(); i++) {
            int len = i * count;
            if (len > n) {
                return ans;
            }
            int[] dp = new int[26];
            int unique = 0;
            for (int st=0, j=0; j<n; j++) {
                int c = s.charAt(j) - 'a';
                if (++dp[c] == count) {
                    unique++;
                }
                if (j > len - 1) {
                    if (dp[s.charAt(st++)-'a']-- == count) {
                        unique--;
                    }
                }
                if (j>= len-1) {
                    if (unique == i) {
                            ans++;
                    }
                }
            }
        }
        return ans;
    }
}