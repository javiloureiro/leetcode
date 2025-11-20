class Solution {

    List<List<String>> result = new ArrayList<>();
    int nGlobal = 0;


    public List<List<String>> solveNQueens(int n) {

        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> diag1 = new HashSet<>();
        HashSet<Integer> diag2 = new HashSet<>();
        List<Integer> curr = new ArrayList<>();

        nGlobal = n;
        dfs(0, curr, cols, diag1, diag2);
        return result;
    }

    public void dfs(Integer row, List<Integer> curr, HashSet<Integer> cols, 
    HashSet<Integer> diag1, HashSet<Integer> diag2){

        if(row == nGlobal){
            result.add(buildBoard(curr));
            return;
        }

        for(int col = 0; col < nGlobal; col++){
            if(!cols.contains(col) && !diag1.contains(row-col) && !diag2.contains(row+col)){
                cols.add(col);
                diag1.add(row-col);
                diag2.add(row+col);
                curr.add(col);
                dfs(row + 1, curr, cols, diag1, diag2);
                cols.remove(col);
                diag1.remove(row-col);
                diag2.remove(row+col);
                curr.remove(curr.size()-1);
            }
        }
    }

    private List<String> buildBoard(List<Integer> curr) {
        List<String> board = new ArrayList<>();
        for (int col : curr) {
            char[] row = new char[nGlobal];
            Arrays.fill(row, '.');
            row[col] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
