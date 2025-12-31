//0 ms
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };

        Solution solve = new Solution();

        System.out.println(solve.isToeplitzMatrix(matrix));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length - 1; i++) {
            if (!isSymmetricalDiagonal(matrix, 0, i)) {
                return false;
            }
        }
        for (int j = 1; j < matrix.length - 1; j++) {
            if (!isSymmetricalDiagonal(matrix, j, 0)) {
                return false;
            }
        }

        return true;

    }

    public boolean isSymmetricalDiagonal(int[][] matrix, int i, int j) {
        int first = matrix[i][j];
        while (i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] != first) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

}
