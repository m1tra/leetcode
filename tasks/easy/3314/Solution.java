import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//O(nm)
public class Solution {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2,3,5,7);

        Solution solve = new Solution();

        System.out.println(solve.minBitwiseArray(nums));
    }

    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i=0; i < nums.size(); i++){
            int num = nums.get(i);
            int candidate = -1;
            for (int j= 1; j<num; j++){
                if ((j | (j+1)) == num){
                    candidate = j;
                    break;
                }
            }
            ans[i] = candidate;
        }

        return ans;
    }

}
