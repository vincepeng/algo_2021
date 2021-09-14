package leetcode.editor.cn;

//208-实现 Trie (前缀树)
public class P208_ImplementTriePrefixTree {

    public static void main(String[] args) {

        Trie solution = new P208_ImplementTriePrefixTree().new Trie();
        solution.insert("apple");
        System.out.println(solution.search("apple"));
        System.out.println(solution.search("appl"));
        System.out.println(solution.search("applea"));
        System.out.println(solution.startsWith("app"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        Trie[] children;

        private boolean isEnd;


        /**
         * Initialize your data structure here.
         */
        public Trie() {
            children = new Trie[26];
            this.isEnd = false;
        }


        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            Trie current = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new Trie();
                }
                current = current.children[index];
            }
            current.isEnd = true;
        }


        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }
            Trie current = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }
            return current != null && current.isEnd;
        }


        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return false;
            }

            Trie current = this;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';

                if (current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }
            return current != null;
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