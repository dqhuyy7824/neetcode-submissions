class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length = 9;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char cell = board[i][j];

                if (cell != '.') {
                    for (int k = 0; k < length; k++) {
                        if (j != k && cell == board[i][k]) return false;
                        if (i != k && cell == board[k][j]) return false;
                        if (i != k/3 + (i/3)*3 && j != k%3 + (j/3)*3 && cell == board[k/3 + (i/3)*3][k%3 + (j/3)*3]) return false;
                    }
                }
            }
        }

        return true;
    }
}
