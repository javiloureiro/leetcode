class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();

        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];


        for (int i = 0; i < r; i++) dfs(i, 0, pacific, heights);
        for (int j = 0; j < c; j++) dfs(0, j, pacific, heights);


        for (int i = 0; i < r; i++) dfs(i, c - 1, atlantic, heights);
        for (int j = 0; j < c; j++) dfs(r - 1, j, atlantic, heights);


        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(atlantic[i][j] && pacific[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    public void dfs(int r, int c, boolean[][] reachable, int[][] heights){
        reachable[r][c] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] d : dirs){
            int nr = r + d[0], nc = c + d[1];

            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length
                && !reachable[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, reachable, heights);
            }
        }
    }
}
