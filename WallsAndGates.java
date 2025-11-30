class Solution {
    Queue<int[]> queue = new LinkedList<>();

    public void islandsAndTreasure(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int r = pos[0], c = pos[1];

            for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];
            

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == Integer.MAX_VALUE){
                    grid[nr][nc] = grid[r][c] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }

        }
    }
}
