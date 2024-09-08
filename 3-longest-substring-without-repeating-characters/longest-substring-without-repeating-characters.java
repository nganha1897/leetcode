class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int prev = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                prev = Math.max(prev, map.get(c) + 1);
            }
            ans = Math.max(ans, i - prev + 1);
            map.put(c, i);
        }
        System.out.println('a');
        return ans;
    }
}