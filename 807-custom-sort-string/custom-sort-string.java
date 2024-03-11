class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        Character[] ch = new Character[s.length()];
        for (int i=0; i<s.length(); i++) {
            ch[i] = s.charAt(i);
        }
        Arrays.sort(ch, (a,b) -> map.getOrDefault(a, 0) - map.getOrDefault(b, 0));

        StringBuilder ans = new StringBuilder();
        for (char c : ch) {
            ans.append(c);
        }

        return ans.toString();
    }
}