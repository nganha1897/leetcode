class Solution {
    public char findTheDifference(String s, String t) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            if (--f[c-'a'] < 0) {
                return c;
            }
        }
        return 'a';
    }
}