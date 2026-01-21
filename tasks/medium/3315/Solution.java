import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//O(n)
public class Solution {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 3, 5, 7);

        Solution solve = new Solution();

        System.out.println(Arrays.toString(solve.minBitwiseArray(nums)));
    }

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int val = nums.get(i);

            if (val % 2 == 0) {
                ans[i] = -1;
            } else {
                long t = (long) val + 1;

                long lowbit = t & -t;

                ans[i] = val - (int) (lowbit >> 1);
            }
        }

        return ans;
    }

}
