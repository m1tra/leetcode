import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//O(1)

public class Solution2{
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        
        Solution2 solve = new Solution2();
        System.out.println(solve.findDisappearedNumbers(arr));

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index]; 
            }
        }

        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++ ){
           if (nums[i]>0){
                list.add(i+1);
           } 
        }

        return list;
        
    }
}