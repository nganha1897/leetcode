class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !isValid(s.charAt(l))) {
                l++;
            }
            while (r > l && !isValid(s.charAt(r))) {
                r--;
            }
            if (l >= r) {
                return true;
            }
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}