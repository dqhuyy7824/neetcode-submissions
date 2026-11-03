class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length = 9;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char cell = board[i][j];

                if (cell != '.') {
                    for (int k = 0; k < length; k++) {

                        // Check row
                        if (j != k && cell == board[i][k]) {
                            return false;
                        }

                        // Check column
                        if (i != k && cell == board[k][j]) {
                            return false;
                        }

                        // Check 3x3 box
                        int row = k / 3 + (i / 3) * 3;
                        int col = k % 3 + (j / 3) * 3;

                        if ((row != i || col != j) && cell == board[row][col]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}