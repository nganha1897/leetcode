class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length() - 1, j = t.length() - 1, countS = 0, countT = 0;
        char[] sa = s.toCharArray(), ta = t.toCharArray();
        while (i >= 0 || j >= 0) {
            //System.out.println(i + " " + j);
            if (i >= 0 && sa[i] == '#') {
                countS++;
                i--;
            }
            else if (j >= 0 && ta[j] == '#') {
                countT++;
                j--;
            }
            else if (countS > 0) {
                countS--;
                i--;
            }
            else if (countT > 0) {
                countT--;
                j--;
            }
            else if (i >= 0 && j >= 0 && sa[i] == ta[j]) {
                i--;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}