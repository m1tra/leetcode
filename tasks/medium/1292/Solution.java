import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 3, 2, 4, 3, 2 }, { 1, 1, 3, 2, 4, 3, 2 }, { 1, 1, 3, 2, 4, 3, 2 } };
        int threshold = 4;

        Solution solve = new Solution();

        System.out.println(solve.maxSideLength(mat, threshold));

    }

    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] prefixSum = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = mat[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }

        for (int dim = Math.min(n, m); dim != 0; dim--) {
            for (int i = 1; i <= n - dim+1; i++) {
                for (int j = 1; j <= m - dim + 1; j++) {
                    int x1 = j, y1 = i, x2 = dim + j - 1, y2 = dim + i - 1;
                    int sum = prefixSum[y2][x2] - prefixSum[y2][x1 - 1] - prefixSum[y1 - 1][x2]
                            + prefixSum[y1 - 1][x1 - 1];
                    if (sum <= threshold) {
                        max = Math.max(max, dim);
                    }
                }
            }
        }

        return max;
    }
}
