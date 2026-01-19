import java.util.Arrays;

//O(n lon n) beats 3.75% :)
public class Solution {
    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1,2,3,4,5};

        Solution solve = new Solution();

        System.out.println(solve.minSubArrayLen(target, nums));

    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        
        for (int i = 1; i <= n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        
        int m = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(prefixSum));
        for (int left = 0; left < n; left++){
            int toFind = target + prefixSum[left];

            int right = Arrays.binarySearch(prefixSum, toFind);

            if (right < 0){
                right = -(right) - 1;
            }

            if (right <= n){
                m = Math.min(right-left,m);
            }
        }
        if (m != Integer.MAX_VALUE){
            return m;
        }
        return 0;
    }
}