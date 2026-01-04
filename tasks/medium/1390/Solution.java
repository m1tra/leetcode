import java.util.HashSet;
import java.util.Set;

//89ms
//time o(m*sqrt(n)) m-len nums n-max(nums[i]) space o(1)
public class Solution {
    public static void main(String[] args) {
        int[] height = { 1, 2, 3, 4, 5 };

        Solution solve = new Solution();

        System.out.println(solve.sumFourDivisors(height));

    }

    public int sumFourDivisors(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            cnt += getSum(num);
        }
        return cnt;
    }

    public int getSum(int n) {
        Set<Integer> set = new HashSet<>();
        int cnt = n + 1;
        set.add(n);
        set.add(1);
        for (int i = 2; i <= (int) (Math.sqrt(n) + 1); i++) {
            if (set.size() > 4) {
                break;
            }
            if (n % i == 0) {
                if (!set.contains(i)) {
                    cnt += i;
                }
                set.add(i);
                if (!set.contains(n / i)) {
                    cnt += n / i;
                }
                set.add(n / i);

            }
        }
        if (set.size() == 4) {
            System.out.println(set);
            System.out.println(n);
            return cnt;
        } else {
            return 0;
        }
    }
}