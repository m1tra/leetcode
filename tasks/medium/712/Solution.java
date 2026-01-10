import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    private String s1, s2;
    private int n, m;
    private int[][] memo;


    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";

        Solution solve = new Solution();
        System.out.println(solve.minimumDeleteSum(s1, s2));
    }

    public int minimumDeleteSum(String a, String b) {
        s1 = a; 
        s2 = b;
        n = s1.length();
        m = s2.length();
        memo = new int[n + 1][m + 1];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return run(0, 0);
    }

    private int run(int i, int j) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        int result;
        if (i == n) {
            result = 0;
            for (int k = j; k < m; k++) result += s2.charAt(k);
        } else if (j == m) {
            result = 0;
            for (int k = i; k < n; k++) result += s1.charAt(k);
        } else if (s1.charAt(i) == s2.charAt(j)) {
            result = run(i + 1, j + 1);
        } else {
            int deleteFromS1 = s1.charAt(i) + run(i + 1, j);
            int deleteFromS2 = s2.charAt(j) + run(i, j + 1);
            result = Math.min(deleteFromS1, deleteFromS2);
        }
        
        memo[i][j] = result;
        return result;
    }
}


