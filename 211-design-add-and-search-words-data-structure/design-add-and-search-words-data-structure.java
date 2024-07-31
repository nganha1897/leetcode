class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        root.add(root, word);
    }
    
    public boolean search(String word) {
        return root.isMatch(root, word, 0);
    }
}

class Trie {
    Trie[] next;
    boolean isEnd;
    
    public Trie() {
        next = new Trie[26];
    }
    
    public void add(Trie cur, String word) {
        for (char c : word.toCharArray()) {
            if (cur.next[c-'a'] == null)
                cur.next[c-'a'] = new Trie();
            cur = cur.next[c-'a'];
        }
        cur.isEnd = true;
    }
    
    public boolean isMatch(Trie cur, String word, int idx) {
        if (idx == word.length())
            return cur.isEnd;
        
        char c = word.charAt(idx);
        if (c == '.') {
            for (int i=0; i<26; i++) {
                if (cur.next[i] != null) {
                    if (isMatch(cur.next[i], word, idx+1))
                        return true;
                }
            }
            return false;
        } else {
            if (cur.next[c-'a'] != null)
                return isMatch(cur.next[c-'a'], word, idx+1);
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */