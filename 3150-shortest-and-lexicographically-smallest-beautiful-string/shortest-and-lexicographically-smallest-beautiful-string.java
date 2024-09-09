class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int start = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) - '0';
            while (count > k || (count == k && s.charAt(start) == '0')) {
                count -= s.charAt(start++) - '0';
            }
            if (count == k) {
                String cur = s.substring(start, i + 1);
                if (ans.length() == 0 || ans.length() > cur.length()) {
                    ans = cur;
                } else if (ans.length() == cur.length()) {
                    if (cur.compareTo(ans) < 0) {
                        ans = cur;
                    }
                }
            }
        }
        return ans;
    }

    private boolean isSmaller(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > t.charAt(i)) {
                //System.out.println(s + " " + t + " " + i);
                return false;
            } else if (s.charAt(i) < t.charAt(i)) {
                return true;
            }
        }
        return true;
    }
}