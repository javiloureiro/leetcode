class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {  
            HashSet<Character> seen1 = new HashSet<>();  

            for (int j = 0; j < board[0].length; j++) {  
                char c = board[i][j];  

                if (c != '.') {  
                    if (seen1.contains(c)) {  
                        return false;
                    }  
                    seen1.add(c);  
                }  
            }  
        }

        for (int j = 0; j < board[0].length; j++) {  
            HashSet<Character> seen2 = new HashSet<>();

            for (int i = 0; i < board.length; i++) {  
                char c = board[i][j];  

                if (c != '.') {  
                    if (seen2.contains(c)) {  
                        return false; 
                    }  
                    seen2.add(c);  
                }  
            }  
        }

        int start = 0;
        int end = 3;
        int count = 0;

        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {

                HashSet<Character> seen3 = new HashSet<>();

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char c = board[startRow + i][startCol + j];

                        if (c != '.') {
                            if (seen3.contains(c)) {
                                return false;
                            }
                            seen3.add(c);
                        }
                    }
                }
            }
        }


        return true;


    }
}
