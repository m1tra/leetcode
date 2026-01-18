import java.util.Arrays;

//8ms
public class Solution {
    public static void main(String[] args) {

        int[][] grid = { { 7, 1, 4, 5, 6 }, { 2, 5, 1, 6, 4 }, { 1, 5, 4, 3, 2 }, { 1, 2, 7, 3, 4 } };

        Solution solve = new Solution();

        System.out.println(solve.largestMagicSquare(grid));

    }

    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] prefixSumRow = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixSumRow[i][j + 1] = prefixSumRow[i][j] + grid[i][j];
            }
        }

        int[][] prefixSumCol = new int[n + 1][m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                prefixSumCol[i + 1][j] = prefixSumCol[i][j] + grid[i][j];
            }
        }

        for (int dim = Math.min(n, m); dim > 1; dim--) {
            for (int i = 0; i <= n - dim; i++) {
                for (int j = 0; j <= m - dim; j++) {

                    int diag1 = 0;
                    int diag2 = 0;
                    for (int k = 0; k < dim; k++) {
                        diag1 += grid[i + k][j + k];
                        diag2 += grid[k + i][dim - k + j - 1];
                    }

                    if (diag1 == diag2) {
                        int c = 0;
                        for (int k = 0; k < dim; k++) {

                            int rowSum =prefixSumRow[i+k][j+dim]-prefixSumRow[i+k][j];
                            if (rowSum!=diag1){break;}
                            int colSum =prefixSumCol[i+dim][j+k]-prefixSumCol[i][j+k];
                            if (colSum!=diag1){break;}
                            c++;
                        }
                        if (c==dim){
                            return c;
                        }

                    }

                }
            }

        }

        return 1;

    }
}
