class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';

            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode();
                
            }
            cur = cur.children[i];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode cur, int j) {
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : cur.children) {
                    if (child != null && dfs(word, child, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = c - 'a';
                if (cur.children[idx] == null) {
                    return false;
                }
                cur = cur.children[idx];
            }
        }

        return cur.endOfWord;
    }
}
