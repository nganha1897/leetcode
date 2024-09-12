class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] f = new int[26];
        for (int i=0; i<allowed.length(); i++) {
            f[allowed.charAt(i) - 'a']++;
        }
        int ans = 0;
        for (String w : words) {
            boolean isConsistent = true;
            for (char c : w.toCharArray()) {
                if (f[c-'a'] == 0) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                ans++;
            }
        }

        return ans;
    }
}