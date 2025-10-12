class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        Boolean isEndOfWord = false;
    }

    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
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
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(node.children[i] == null){
                return false;
            }
            node = node.children[i];
        }
        return node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            int i = c - 'a';
            if(node.children[i] == null){
                return false;
            }
            node = node.children[i];
        }
        return true;
    }

    public List<String> findWords(char[][] board, String[] words) {

        Set<String> result = new HashSet<>();
        for(String word : words){
            insert(word);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                char c = board[i][j];
                dfs(board, i, j, root, "", result);
            }
        }

        return new ArrayList<>(result);
    }

    void dfs(char[][] board, int i, int j, TrieNode node, String prefix, Set<String> result){
        if(i < 0 || i >= board.length || j < 0 || j>= board[i].length) return;

        char c = board[i][j];
        if(c == '#' || node.children[c-'a'] == null) return;

        node = node.children[c - 'a'];
        prefix += c;

        if(node.isEndOfWord){
            result.add(prefix);
            node.isEndOfWord = false;
        }

        board[i][j] = '#';

        dfs(board, i+1, j, node, prefix, result);
        dfs(board, i-1, j, node, prefix, result);
        dfs(board, i, j+1, node, prefix, result);
        dfs(board, i, j-1, node, prefix, result);

        board[i][j] = c;
    }
}
