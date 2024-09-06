import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int countValidWords(String sentence) {
        String[] w = sentence.split(" ");
        String regex = "^(([a-z]*)|([a-z]+-[a-z]+))[!.,]?$";
        int ans = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        for (String s : w) {
            if (s.length() == 0) {
                continue;
            }
            matcher = pattern.matcher(s);
            if (matcher.find()) {
                System.out.println(s);
                ans++;
            }
        }
        return ans;
    }
}