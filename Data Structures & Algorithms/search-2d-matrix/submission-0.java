class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowStart = 0;
        int columnStart = 0;
        int rowEnd = matrix.length - 1;
        int columnEnd = matrix[0].length - 1;

        while (rowStart*matrix[0].length + columnStart <= rowEnd*matrix[0].length + columnEnd) {
            int index = ((rowEnd*matrix[0].length + columnEnd) + (rowStart*matrix[0].length + columnStart)) / 2;

            int indexRow = index / matrix[0].length;
            int indexColumn = index % matrix[0].length;

            if (matrix[indexRow][indexColumn] == target) return true;
            if (matrix[indexRow][indexColumn] < target) {
                rowStart = (index + 1) / matrix[0].length;
                columnStart = (index + 1) % matrix[0].length;
            } else {
                rowEnd = (index - 1) / matrix[0].length;
                columnEnd = (index - 1) % matrix[0].length;
            }
        }

        return false;
    }
}
