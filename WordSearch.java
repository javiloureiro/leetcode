class Solution {
    char[][] boardG;
    String wordG;
    boolean result = false;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        boardG = board;
        wordG = word;
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(0, i, j, new StringBuilder());
                if(result) return true;
            }
        }

        return result;
    }

    public void dfs(int pos, int i, int j, StringBuilder sb) {
        if(pos == wordG.length()){
            result = true;
            return;
        }
        if(i < 0 || i >= boardG.length || j < 0 || j >= boardG[0].length) return;
        if(visited[i][j]) return;
        if(boardG[i][j] != wordG.charAt(pos)) return;

        sb.append(boardG[i][j]);
        visited[i][j] = true;

        dfs(pos + 1, i + 1, j, sb);
        dfs(pos + 1, i - 1, j, sb);
        dfs(pos + 1, i, j + 1, sb);
        dfs(pos + 1, i, j - 1, sb);

        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}
