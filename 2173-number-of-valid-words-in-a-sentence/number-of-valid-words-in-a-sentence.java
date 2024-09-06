class Solution {
    // public int countValidWords(String sentence) {
    //     String[] w = sentence.split(" ");
    //     String regex = "^(([a-z]*)|([a-z]+-[a-z]+))[!.,]?$";
    //     int ans = 0;

    //     for (String s : w) {
    //         if (s.length() > 0 && s.matches(regex)) {
    //             ans++;
    //         }
    //     }
    //     return ans;
    // }
    public int countValidWords(String sentence) {
        int ans = 0;
        String[] w = sentence.split(" ");
        for (String s : w) {
            if (s.length() > 0 && isValid(s)) {
                ans++;
            }
        }
        return ans;
    }
    private boolean isValid(String s) {
        int hyphen = 0;
        int hyphenPos = -2;
        char[] a = s.toCharArray();

        for (int i=0; i<a.length; i++) {
            char c = a[i];
            if ((c < 'a' || c > 'z') && (c != '-' && c != '!' && c != '.' && c != ',')) {
                return false;
            }
            if (c == '-' && (hyphen > 0 || i == 0 || i == a.length-1)) {
                return false;
            } else if (c == '-') {
                hyphen++;
                hyphenPos = i;
            }
            if ((c == '!' || c == '.' || c == ',') && (i < a.length-1 || hyphenPos == i-1)) {
                return false;
            }
        }
        return true;
    }
}