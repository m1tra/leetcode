import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//O(n) по памяти - в задаче просилось O(1)

public class Solution1{
    public static void main(String[] args) {
        int[] arr = {1,9,3,5,2,7,9,9};
        
        Solution1 solve = new Solution1();

        System.out.println(solve.findDisappearedNumbers(arr));

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i<nums.length; i++){
            if (!hash.containsKey(nums[i])){
                hash.put(nums[i],nums[i]);
            }
        }

        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= nums.length; i++ ){
            if (!hash.containsKey(i)){
                list.add(i);
            }
        }

        return list;
        
    }
}