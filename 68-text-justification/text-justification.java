class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < words.length;) {
            StringBuilder s = new StringBuilder();
            int len = words[i].length();
            int j = i + 1;
            while (j < words.length && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j++].length();
            }
            if (j - i - 1 > 0) {
                if (j == words.length) {
                    for (int k = i; k < j; k++) {
                        s.append(words[k]);
                        if (k != j - 1) {
                            s.append(" ");
                        }
                    }
                    int rem = maxWidth - len;
                    while (rem-- > 0) {
                        s.append(" ");
                    }
                } else {
                    int sp = (maxWidth - len + j - i - 1) / (j - i - 1);
                    int rem = (maxWidth - len + j - i - 1) % (j - i - 1);
                    for (int k = i; k < j; k++) {
                        s.append(words[k]);
                        if (k != j - 1) {
                            for (int m = 0; m < sp; m++) {
                                s.append(" ");
                            }
                            if (rem > 0) {
                                s.append(" ");
                                rem--;
                            }
                        }
                    }
                }
            } else {
                s.append(words[i]);
                int rem = maxWidth - words[i].length();
                while (rem-- > 0) {
                    s.append(" ");
                }
            }
            ans.add(s.toString());
            i = j;
        }
        return ans;
    }
}