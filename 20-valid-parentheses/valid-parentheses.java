class Solution {
    public boolean isValid(String s) {
        Deque<Character> d = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                d.offerLast(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (d.isEmpty() || d.pollLast() != '(') {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (d.isEmpty() || d.pollLast() != '[') {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (d.isEmpty() || d.pollLast() != '{') {
                    return false;
                }
            }    
        }
        return d.isEmpty();
    }
}