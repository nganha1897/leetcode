class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int n = word.length();
        Trie root = new Trie();
        for (String f : forbidden) {
            root.add(f);
        }
        int ans = 0;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            int start = prev == -1 ? i : prev;
            Trie cur = root;
            int j = i;
            boolean canExtend = true;
            for (; j >= Math.max(i - 10, start); j--) {
                int pos = word.charAt(j) - 'a';

                if (cur.children[pos] == null) {
                    //System.out.println("a " + prev);
                    canExtend = false;
                    prev = (prev == -1 ? i : prev);
                    ans = Math.max(ans, i - prev + 1);
                    
                    break;
                }
                cur = cur.children[pos];
                if (cur.isWord) {
                    // System.out.println(j + " " + i);
                    canExtend = false;
                    prev = j + 1 <= i ? (j + 1) : -1;
                    ans = Math.max(ans, prev == -1 ? 0 : (ans - prev + 1));
                    //System.out.println('b');
                    break;
                } else {
                    ans = Math.max(ans, i - j + 1);
                }
                //System.out.println(j+ " " + i + " " + prev + " " + ans);
            }
            if (canExtend) {
                prev = start;
            }
            //System.out.println(i + " " + prev + " " + ans);
        }
        return ans;
    }
}

class Trie {
    Trie[] children;
    boolean isWord;

    public Trie() {
        children = new Trie[26];
    }

    public void add(String s) {
        Trie cur = this;
        for (int i = s.length() - 1; i >= 0; i--) {
            int pos = s.charAt(i) - 'a';
            if (cur.children[pos] == null) {
                cur.children[pos] = new Trie();
            }
            cur = cur.children[pos];
        }
        cur.isWord = true;
    }
}