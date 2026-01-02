import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3 };

        Solution solve = new Solution();

        System.out.println(solve.repeatedNTimes(nums));
    }

    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0 ; i<nums.length; i++){
            if (hash.containsKey(nums[i])){
                return nums[i];
            }
            hash.put(nums[i],nums[i]);

        }
        return 1;
    }

}
