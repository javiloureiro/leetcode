class WordDictionary {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    TrieNode root = new TrieNode();

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(node.children[i] == null){
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node){

        if (node == null) return false;
        if (index == word.length()) return node.isEndOfWord;

        char c = word.charAt(index);

        if(c == '.'){
            for(TrieNode child : node.children){
                if(child != null && dfs(word, index + 1, child)){
                    return true;
                }
            }
            return false;
        }else{
            int i = c - 'a';
            return dfs(word, index + 1, node.children[i]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
