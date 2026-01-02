import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 9, 9 };

        Solution solve = new Solution();

        System.out.println(Arrays.toString(solve.plusOne(nums)));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i]+1;
            if (num != 10) {
                digits[i] = num;
                return digits;
            }
            digits[i] = 0;
        }
        int[] lst = new int[digits.length+1];
        lst[0]=1;
        return lst;
        
    }

}
