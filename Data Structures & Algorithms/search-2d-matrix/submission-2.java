class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while (left <= right) {
            int index = (left + right) / 2;

            int row = index / matrix[0].length;
            int column = index % matrix[0].length;

            if (matrix[row][column] == target) return true;
            if (matrix[row][column] < target) left = index + 1;
            else right = index - 1;
        }

        return false;
    }
}
