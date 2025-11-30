class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] saved = new boolean[rows][cols];

        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
                saved[i][0] = true;
            }
            if(board[i][cols - 1] == 'O') {
                queue.add(new int[]{i, cols - 1});
                saved[i][cols - 1] = true;
            }
        }
        for(int j = 0; j < cols; j++){
            if(board[0][j] == 'O') {
                queue.add(new int[]{0, j});
                saved[0][j] = true;
            }
            if(board[rows - 1][j] == 'O') {
                queue.add(new int[]{rows - 1, j});
                saved[rows - 1][j] = true;
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!queue.isEmpty()){
            int pos[] = queue.poll();
            int r = pos[0], c = pos[1];

            for(int[] d : dirs){
                int nr = r + d[0], nc = c + d[1];

                if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length){
                    if(board[nr][nc] == 'O' && !saved[nr][nc]){
                        saved[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O' && !saved[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}
