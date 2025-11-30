class Solution {
    Queue<int[]> queue = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int freshcount = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }else if (grid[i][j] == 1){
                    freshcount++;
                }
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rottedThisMinute = false;

            for(int i = 0; i < size; i++){
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];

                 for(int[] d : dirs){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        freshcount--;
                        rottedThisMinute = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            if(rottedThisMinute) minutes++;
        }

        return freshcount == 0 ? minutes : -1;
    }
}
