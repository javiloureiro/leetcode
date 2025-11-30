class Solution {

    int max = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }

        return max;
    }

    public int dfs(int i, int j, int[][]grid){
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;

        int curr = 1;

        curr += dfs(i+1, j, grid);
        curr += dfs(i-1, j, grid);
        curr += dfs(i, j+1, grid);
        curr += dfs(i, j-1, grid);

        return curr;
    }
}
