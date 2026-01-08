public class Solution {
    public static void main(String[] args) {
        int[] nums1 = { 2, 1, -2, 5 };
        int[] nums2 = { 3, 0, -6 };

        Solution solve = new Solution();

        System.out.println(solve.maxDotProduct(nums1, nums2));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = Integer.MIN_VALUE / 2;
        for (int j = 0; j <= m; j++)
            dp[0][j] = Integer.MIN_VALUE / 2;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int product = nums1[i - 1] * nums2[j - 1];
                
                dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]),
                        Math.max(dp[i - 1][j - 1] + product, product));
            }
        }
        return dp[n][m];
    }

}
