class Solution {
    public int equalCountSubstrings(String s, int count) {
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
                if (dp[c]++ == 0) {
                    unique++;
                }
                if (j > len - 1) {
                    if (--dp[s.charAt(st++)-'a'] == 0) {
                        unique--;
                    }
                }
                if (j>= len-1) {
                    if (unique == i) {
                        boolean isEqCnt = true;
                        for (int k=0; k<26; k++) {
                            if (dp[k] > 0 && dp[k] < count) {
                                isEqCnt = false;
                                break;
                            }
                        }
                        if (isEqCnt)
                            ans++;
                        //System.out.println(st + " " + j + " " + count + " " + len + " " + ans);
                    }
                }
                //System.out.println(i + " " + st + " " + j + " " + unique);
            }
        }
        return ans;
    }
}