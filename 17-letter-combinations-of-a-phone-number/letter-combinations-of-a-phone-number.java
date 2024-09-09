class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        combine(phone, digits, 0, new StringBuilder(), ans);
        return ans;
    }
    private void combine(String[] phone, String digits, int cur, StringBuilder s, List<String> ans) {
        if (cur == digits.length()) {
            ans.add(s.toString());
            return;
        }
        for (char c : phone[digits.charAt(cur)-'0'].toCharArray()) {
            combine(phone, digits, cur+1, new StringBuilder(s).append(c), ans);
        }
    }
}