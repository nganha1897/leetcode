class Solution {
    public String smallestString(String s) {
        StringBuilder ans = new StringBuilder();
        int replace = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c != 'a') {
                ans.append((char)(c-1));
                replace++;
            } else {
                if (replace == 0 && i == s.length()-1) {
                    ans.append('z');
                }
                else if (replace > 0) {
                    ans.append(s.substring(i));
                    return ans.toString();
                } else {
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }
}