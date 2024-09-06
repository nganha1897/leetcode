class Solution {
    public int countValidWords(String sentence) {
        String[] w = sentence.split(" ");
        String regex = "^(([a-z]*)|([a-z]+-[a-z]+))[!.,]?$";
        int ans = 0;

        for (String s : w) {
            if (s.length() > 0 && s.matches(regex)) {
                ans++;
            }
        }
        return ans;
    }
}