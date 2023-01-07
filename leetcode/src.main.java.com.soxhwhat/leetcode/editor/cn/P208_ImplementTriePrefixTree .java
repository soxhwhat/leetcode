package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 实现 Trie (前缀树)
 * implement-trie-prefix-tree
 * 2023-01-05 18:08:55
 *
 * @author soxhwhat
 */
class P208_ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie solution = new P208_ImplementTriePrefixTree().new Trie();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private Trie[] son;
        private boolean isEnd;

        public Trie() {
            son = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int u = c - 'a';
                if (node.son[u] == null) {
                    node.son[u] = new Trie();
                }
                node = node.son[u];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = this;
            Trie trie = checkPrefix(word, node);
            return trie != null && trie.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = this;
            return checkPrefix(prefix, node) != null;
        }

        private Trie checkPrefix(String prefix, Trie node) {
            for (char c : prefix.toCharArray()) {
                int u = c - 'a';
                if (node.son[u] == null) return null;
                node = node.son[u];
            }
            return node;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}