class Solution {
    // public int expressiveWords(String s, String[] words) {
    // int ans = 0;
    // char[] sarr = s.toCharArray();
    // for (String w : words) {
    // char[] warr = w.toCharArray();
    // if (sarr[0] != warr[0]) {
    // continue;
    // }

    // boolean isStretchy = true;
    // int i=1, j=1, count = 1;
    // while (i<sarr.length && j<warr.length) {
    // if (sarr[i] == warr[j]) {
    // if (sarr[i] == sarr[i-1]) {
    // count++;
    // } else {
    // count = 1;
    // }
    // i++;
    // j++;
    // } else {
    // if (sarr[i] != sarr[i-1]) {
    // isStretchy = false;
    // break;
    // }
    // while (i < sarr.length && sarr[i] == sarr[i-1]) {
    // count++;
    // i++;
    // }
    // if (count < 3) {
    // isStretchy = false;
    // break;
    // }
    // }
    // }
    // if (!isStretchy) {
    // continue;
    // }
    // if (i == sarr.length && j == warr.length) {
    // if (isStretchy) {
    // ans++;
    // }
    // continue;
    // }
    // while (i < sarr.length) {
    // if (sarr[i] != sarr[i-1]) {
    // isStretchy = false;
    // break;
    // }
    // i++;
    // count++;
    // }
    // if (j < warr.length) {
    // isStretchy = false;
    // continue;
    // }
    // if (isStretchy && count >= 3) {
    // ans++;
    // }
    // }
    // return ans;
    // }

    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String w : words) {
            if (isStretchy(s, w))
                ans++;
        }
        return ans;
    }

    private boolean isStretchy(String s, String w) {
        int i = 0, j = 0;
        while (i < s.length() && j < w.length()) {
            if (s.charAt(i) == w.charAt(j)) {
                int lenS = noOfRepetitions(s, i);
                int lenW = noOfRepetitions(w, j);
                if (lenS < lenW || (lenS > lenW && lenS < 3)) {
                    return false;
                }
                i += lenS;
                j += lenW;
            } else {
                return false;
            }
        }
        if (i < s.length() || j < w.length()) {
            return false;
        }
        return true;
    }

    private int noOfRepetitions(String s, int i) {
        for (int j = i + 1; j < s.length(); j++) {
            if (s.charAt(j) != s.charAt(i)) {
                return j - i;
            }
        }
        return s.length() - i;
    }
}